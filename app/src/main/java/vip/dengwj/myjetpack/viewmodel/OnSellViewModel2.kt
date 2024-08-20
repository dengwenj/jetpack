package vip.dengwj.myjetpack.viewmodel

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
        MutableLiveData<List<OnSellData.ListBean>>()
    }

    private val repository by lazy {
        OnSellRepository2()
    }

    fun loadData() {
        // loading
        loadState.value = LoadState.LOADING

        loadPageData(page)
    }

    private fun loadPageData(page1: Int) {
        viewModelScope.launch {
            try {
                val res = repository.getOnSellByPage(page1)
                if (res.data.list.isEmpty()) {
                    loadState.value = LoadState.EMPTY
                } else {
                    contentList.postValue(res.data.list)
                    loadState.value = LoadState.SUCCESS
                }
            } catch (e: Exception) {
                loadState.value = LoadState.ERROR
            }
        }
    }
}