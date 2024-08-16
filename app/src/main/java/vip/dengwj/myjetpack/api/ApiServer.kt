package vip.dengwj.myjetpack.api

import retrofit2.http.GET
import retrofit2.http.Path
import vip.dengwj.myjetpack.domain.OnSellData
import vip.dengwj.myjetpack.domain.ResultData

interface ApiServer {
    companion object {
        const val BASE_URL = "https://api.taobaounion.cn/"
    }

    @GET("/shop/r/{page}")
    suspend fun getOnSellData(@Path("page") page: Int): ResultData<OnSellData>
}