package vip.dengwj.myjetpack.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vip.dengwj.myjetpack.domain.OnSellData
import vip.dengwj.myjetpack.repository.OnSellRepository2
import vip.dengwj.myjetpack.util.LoadState

class OnSellViewModel2 : ViewModel() {
    companion object {
        const val DEFAULT_PAGE = 1
    }

    private val page = DEFAULT_PAGE

    // 所需要的数据
    val loadState by lazy {
        // 监听数据的变化
        MutableLiveData<LoadState>()
    }

    val contentList by lazy {
        MutableLiveData<List<OnSellData>>()
    }

    private val repository by lazy {
        OnSellRepository2()
    }

    fun loadData() {
        // loading
        loadState.value = LoadState.LOADING

        loadPageData()
    }

    private fun loadPageData() {
        viewModelScope.launch {
            val res = repository.getOnSellByPage(page)
            Log.d("pumu", "size -> ${res.data.list.size}")
        }
    }
}