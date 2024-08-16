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

    companion object {
        const val DEFAULT_PAGE = 1
    }

    private var currentPage = DEFAULT_PAGE

    /**
     * 加载更多
     */
    fun loadMore() {
        currentPage++
        loadDataByPage(currentPage)
    }

    /**
     * 首次加载
     */
    fun loadContent() {
        loadDataByPage(currentPage)
    }

    private fun loadDataByPage(page: Int) {
        // 加载中...
        loadState.value = LoadState.LOADING

        viewModelScope.launch {
            try {
                val res = onSellRepository.getData(page)

                if (res.data.list.isEmpty()) {
                    loadState.value = LoadState.EMPTY
                } else {
                    onSellLiveData.postValue(res.data.list)
                    loadState.value = LoadState.SUCCESS
                }
            } catch (e: Exception) {
                loadState.value = LoadState.ERROR
            }
        }
    }
}