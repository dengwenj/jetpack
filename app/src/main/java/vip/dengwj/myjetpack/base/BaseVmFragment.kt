package vip.dengwj.myjetpack.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 设置公共的 MVVM
 */
abstract class BaseVmFragment<T : ViewDataBinding, VM : ViewModel> : BaseViewFragment<T>() {
    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 创建 ViewModel
        initViewModel()
        // 观察 ViewModel 里的数据变化
        observerData()
        // 初始化 View
        initView()
        // 设置相关的事件
        initEvent()
        // 开始去加载数据
        startLoadData()
    }

    open fun initView() {

    }

    open fun startLoadData() {

    }

    open fun initEvent() {

    }

    open fun observerData() {

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[getModelClass()]
    }

    abstract fun getModelClass(): Class<VM>
}
