package vip.dengwj.myjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vip.dengwj.myjetpack.domain.OnSellData
import vip.dengwj.myjetpack.util.LoadState

class OnSellViewModel2 : ViewModel() {
    // 所需要的数据
    val loadState by lazy {
        // 监听数据的变化
        MutableLiveData<LoadState>()
    }

    val contentList by lazy {
        MutableLiveData<List<OnSellData>>()
    }
}