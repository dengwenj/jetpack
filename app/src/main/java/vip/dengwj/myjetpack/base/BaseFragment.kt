package vip.dengwj.myjetpack.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import vip.dengwj.myjetpack.lifecycle.LifeState
import vip.dengwj.myjetpack.lifecycle.LifecycleProvider1

open class BaseFragment : Fragment() {
    val lifecycleProvider by lazy {
        LifecycleProvider1()
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
}