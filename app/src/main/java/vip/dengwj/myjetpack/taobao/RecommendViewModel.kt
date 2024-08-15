package vip.dengwj.myjetpack.taobao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendViewModel : ViewModel() {
    private val recommendLiveData = MutableLiveData<List<String>>()
}