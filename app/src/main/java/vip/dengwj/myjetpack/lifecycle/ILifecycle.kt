package vip.dengwj.myjetpack.lifecycle

interface ILifecycle {
    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}