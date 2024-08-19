package vip.dengwj.myjetpack.fragment

import android.util.Log
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseVmFragment
import vip.dengwj.myjetpack.databinding.FragmentOnSell2Binding
import vip.dengwj.myjetpack.viewmodel.OnSellViewModel2

class OnSellFragment2 : BaseVmFragment<FragmentOnSell2Binding, OnSellViewModel2>() {
    override fun getModelClass(): Class<OnSellViewModel2> {
        return OnSellViewModel2::class.java
    }

    override fun getRootViewId(): Int {
        return R.layout.fragment_on_sell_2
    }

    override fun observerData() {
        viewModel.loadState.observe(this) {
            Log.d("pumu", "newState -> $it")
        }

        viewModel.contentList.observe(this) {
            Log.d("pumu", "contentList.size -> ${it.size}")
        }
    }
}