package vip.dengwj.myjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockViewModel : ViewModel() {
    // 需要变动的数据
    // 当前股价
    val currentSocket = MutableLiveData<String>()

    // 卖出数量
    val socketCount = MutableLiveData<String>()
}