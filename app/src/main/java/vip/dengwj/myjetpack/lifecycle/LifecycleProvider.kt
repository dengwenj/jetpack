package vip.dengwj.myjetpack.lifecycle

/**
 * 管理所注册进来的接口，这个接口就 ILifecycle
 * 保存当前 View 的生命周期状态
 */
class LifecycleProvider1 {
    private val lifeListenerList = arrayListOf<ILifecycle>()

    fun addLifeListener(listener: ILifecycle) {
        if (!lifeListenerList.contains(listener)) {
            lifeListenerList.add(listener)
        }
    }

    fun removeLifeListener(listener: ILifecycle) {
        lifeListenerList.remove(listener)
    }

    fun makeLifeState(state: LifeState) {
        when (state) {
            LifeState.CREATE -> dispatchCreate()
            LifeState.START -> dispatchStart()
            LifeState.RESUME -> dispatchResume()
            LifeState.PAUSE -> dispatchPause()
            LifeState.STOP -> dispatchStop()
            LifeState.DESTROY -> dispatchDestroy()
        }
    }

    private fun dispatchDestroy() {
        lifeListenerList.forEach {
            it.onDestroy()
        }
        lifeListenerList.clear()
    }

    private fun dispatchStop() {
        lifeListenerList.forEach {
            it.onStop()
        }
    }

    private fun dispatchPause() {
        lifeListenerList.forEach {
            it.onPause()
        }
    }

    private fun dispatchResume() {
        lifeListenerList.forEach {
            it.onResume()
        }
    }

    private fun dispatchStart() {
        lifeListenerList.forEach {
            it.onStart()
        }
    }

    private fun dispatchCreate() {
        lifeListenerList.forEach {
            it.onCreate()
        }
    }
}