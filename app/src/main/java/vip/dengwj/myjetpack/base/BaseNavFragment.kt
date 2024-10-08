package vip.dengwj.myjetpack.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseNavFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getRootViewId(), container, false)
        Log.d("pumu", "进了吗" + getRootViewId())
        // 初始化 View
        initView(view)

        return view
    }

    open fun initView(view: View) {

    }

    abstract fun getRootViewId(): Int
}