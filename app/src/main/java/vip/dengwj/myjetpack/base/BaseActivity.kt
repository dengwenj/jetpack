package vip.dengwj.myjetpack.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vip.dengwj.myjetpack.lifecycle.ILifecycleOwner
import vip.dengwj.myjetpack.lifecycle.LifeState
import vip.dengwj.myjetpack.lifecycle.LifecycleProvider

open class BaseActivity : AppCompatActivity(), ILifecycleOwner {
    val lifecycleProvider by lazy {
        LifecycleProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleProvider.makeLifeState(LifeState.CREATE)
    }

    override fun onStart() {
        super.onStart()
        lifecycleProvider.makeLifeState(LifeState.START)
    }

    override fun onResume() {
        super.onResume()
        lifecycleProvider.makeLifeState(LifeState.RESUME)
    }

    override fun onPause() {
        super.onPause()
        lifecycleProvider.makeLifeState(LifeState.PAUSE)
    }

    override fun onStop() {
        super.onStop()
        lifecycleProvider.makeLifeState(LifeState.STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleProvider.makeLifeState(LifeState.DESTROY)
    }

    override fun getLifecycleProvider(): LifecycleProvider {
        return lifecycleProvider
    }
}