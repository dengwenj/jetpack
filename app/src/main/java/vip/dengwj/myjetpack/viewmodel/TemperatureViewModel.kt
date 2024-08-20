package vip.dengwj.myjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vip.dengwj.myjetpack.util.TempSensorType

class TemperatureViewModel : ViewModel() {
    val supportTest by lazy {
        val data = MutableLiveData<TempSensorType>()
        data.value = TempSensorType.BODY_ENV
        data
    }

    // 体温
    val bodyVal by lazy {
        val data = MutableLiveData<Double>()
        data.value = 37.0
        data
    }

    // 环境温度
    val envVal by lazy {
        val data = MutableLiveData<Double>()
        data.value = 25.0
        data
    }
}