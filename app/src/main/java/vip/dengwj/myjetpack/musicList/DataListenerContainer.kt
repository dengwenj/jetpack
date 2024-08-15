package vip.dengwj.myjetpack.musicList

import android.os.Looper
import vip.dengwj.myjetpack.App

/**
 * 数据容器
 * 可以监听数据的变化
 * TODO 让数据容器也具备感知 View 生命周期变化的能力
 */
class DataListenerContainer<T> {
    private val blocks = arrayListOf<(T) -> Unit>()

    // 数据改变
    var value: T? = null
        set(value) {
            field = value
            // 判断当前线程是否在主线程
            // 如果是，则直接执行，否则切换到主线程，UI 更新必须在主线程
            if (Looper.getMainLooper().thread === Thread.currentThread()) {
                blocks.forEach {
                    it.invoke(value!!)
                }
            } else {
                App.handler.post {
                    blocks.forEach {
                        it.invoke(value!!)
                    }
                }
            }
        }

    fun addListener(block: (T) -> Unit) {
        if (!blocks.contains(block)) {
            blocks.add(block)
        }
    }
}