package vip.dengwj.myjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vip.dengwj.myjetpack.util.TempSensorType

class TemperatureViewModel : ViewModel() {
    val supportTest by lazy {
        val data = MutableLiveData<TempSensorType>()
        data.value = TempSensorType.NONE
        data
    }

    // 体温
    val bodyVal = MutableLiveData<Double>()

    // 环境温度
    val envVal = MutableLiveData<Double>()
}