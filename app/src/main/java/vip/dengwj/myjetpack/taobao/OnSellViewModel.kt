package vip.dengwj.myjetpack.taobao

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vip.dengwj.myjetpack.base.LoadState
import vip.dengwj.myjetpack.domain.OnSellData

class OnSellViewModel : ViewModel() {
    val onSellLiveData = MutableLiveData<List<OnSellData.ListBean>>()

    val loadState = MutableLiveData<LoadState>()

    private val onSellRepository by lazy {
        OnSellRepository()
    }

    private var isMore = false

    companion object {
        const val DEFAULT_PAGE = 1
    }

    private var currentPage = DEFAULT_PAGE

    /**
     * 加载更多
     */
    fun loadMore() {
        isMore = true
        loadState.value = LoadState.LOADING_MORE
        currentPage++
        loadDataByPage(currentPage)
    }

    /**
     * 首次加载
     */
    fun loadContent() {
        isMore = false
        loadState.value = LoadState.LOADING
        loadDataByPage(currentPage)
    }

    private fun loadDataByPage(page: Int) {
        viewModelScope.launch {
            try {
                val res = onSellRepository.getData(page)

                if (res.data.list.isEmpty()) {
                    loadState.value = if (!isMore) LoadState.EMPTY else LoadState.EMPTY_MORE
                } else {
                    onSellLiveData.postValue(res.data.list)
                    loadState.value = if (!isMore) LoadState.SUCCESS else LoadState.SUCCESS_MORE
                }
            } catch (e: Exception) {
                loadState.value = if (!isMore) {
                    LoadState.ERROR
                } else {
                    currentPage--
                    LoadState.ERROR_MORE
                }
            }
        }
    }
}