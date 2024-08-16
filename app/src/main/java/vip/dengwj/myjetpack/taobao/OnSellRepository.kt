package vip.dengwj.myjetpack.taobao

import android.util.Log
import vip.dengwj.myjetpack.api.RetrofitClient
import vip.dengwj.myjetpack.domain.OnSellData
import vip.dengwj.myjetpack.domain.ResultData

class OnSellRepository {
    suspend fun getData(page: Int): ResultData<OnSellData> {
        return RetrofitClient.apiServer.getOnSellData(page)
    }
}