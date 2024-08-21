package vip.dengwj.myjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockViewModel : ViewModel() {
    // 需要变动的数据
    // 当前股价
    val currentSocket = MutableLiveData<String>()

    // 卖出数量
    val socketCount = MutableLiveData<String>()

    // 预计
    val totalVal by lazy {
        val data = MutableLiveData<String>()
        data.value = "0.00"
        data
    }

    fun updateTotal() {
        var current = 0.00f
        if (currentSocket.value != null && currentSocket.value != "") {
            current = currentSocket.value!!.toFloat()
        }

        var count = 0
        if (socketCount.value != null && socketCount.value != "") {
            count = socketCount.value!!.toInt()
        }

        val total = current * count
        totalVal.value = String.format("%.2f", total)
    }
}