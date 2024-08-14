package vip.dengwj.myjetpack.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vip.dengwj.myjetpack.lifecycle.ILifecycle

open class BaseActivity : AppCompatActivity() {
    private val lifeListenerList = arrayListOf<ILifecycle>()

    fun addLifeListener(listener: ILifecycle) {
        if (!lifeListenerList.contains(listener)) {
            lifeListenerList.add(listener)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeListenerList.forEach {
            it.onCreate()
        }
    }

    override fun onStart() {
        super.onStart()
        lifeListenerList.forEach {
            it.onStart()
        }
    }

    override fun onResume() {
        super.onResume()
        lifeListenerList.forEach {
            it.onResume()
        }
    }

    override fun onPause() {
        super.onPause()
        lifeListenerList.forEach {
            it.onPause()
        }
    }

    override fun onStop() {
        super.onStop()
        lifeListenerList.forEach {
            it.onStop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeListenerList.forEach {
            it.onDestroy()
        }
    }
}