package vip.dengwj.myjetpack.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseViewFragment<T : ViewDataBinding> : Fragment() {
    var binding: T? = null

    var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 方式一
        //val rootView = inflater.inflate(getRootViewId(), container, false)
        //binding = DataBindingUtil.bind(rootView)

        // 方式二
        binding = DataBindingUtil.inflate(inflater, getRootViewId(), container, false)
        rootView = binding!!.root
        return rootView
    }

    abstract fun getRootViewId(): Int
}