package vip.dengwj.myjetpack.musicList

import android.os.Looper
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import vip.dengwj.myjetpack.App

/**
 * 数据容器
 * 可以监听数据的变化
 * TODO 让数据容器也具备感知 View 生命周期变化的能力
 */
class DataListenerContainer<T> {
    private val blocks = arrayListOf<(T) -> Unit>()
    private val viewLifecycleProviders = hashMapOf<(T) -> Unit, Lifecycle>()

    // 数据改变
    var value: T? = null
        set(value) {
            field = value
            // 判断当前线程是否在主线程
            // 如果是，则直接执行，否则切换到主线程，UI 更新必须在主线程
            if (Looper.getMainLooper().thread === Thread.currentThread()) {
                blocks.forEach {
                    dispatchValue(it, value!!)
                }
            } else {
                App.handler.post {
                    blocks.forEach {
                        dispatchValue(it, value!!)
                    }
                }
            }
        }

    fun addListener(owner: LifecycleOwner, valueObserver: (T) -> Unit) {
        val lifecycle = owner.lifecycle
        viewLifecycleProviders[valueObserver] = lifecycle

        val valueObserverWrapper = ValueObserverWrapper(valueObserver)
        lifecycle.addObserver(valueObserverWrapper)

        if (!blocks.contains(valueObserver)) {
            blocks.add(valueObserver)
        }
    }

    private fun dispatchValue(it: (T) -> Unit, value: T) {
        val lifecycle = viewLifecycleProviders[it]
        if (lifecycle != null && lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            Log.d("pumu", "UI 可见")
            it.invoke(value)
        } else {
            Log.d("pumu", "UI 不可见")
        }
    }

    inner class ValueObserverWrapper(private val valueObserver: (T) -> Unit) : LifecycleObserver {
        // 当 View destroy 的时候，要从集合中删除
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun removeValueObserver() {
            Log.d("pumu", "删除了")
            viewLifecycleProviders.remove(valueObserver)
        }
    }
}