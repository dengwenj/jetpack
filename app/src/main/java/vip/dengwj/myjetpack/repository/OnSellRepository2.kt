package vip.dengwj.myjetpack.repository

import vip.dengwj.myjetpack.api.RetrofitClient
import vip.dengwj.myjetpack.domain.OnSellData
import vip.dengwj.myjetpack.domain.ResultData

class OnSellRepository2 {
    suspend fun getOnSellByPage(page: Int): ResultData<OnSellData> {
        return RetrofitClient.apiServer.getOnSellData(page)
    }
}