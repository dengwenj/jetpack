package vip.dengwj.myjetpack.player

import androidx.lifecycle.LiveData

class LiveDataState private constructor() : LiveData<PlayerPresenter.PlayerState>() {
    public override fun postValue(value: PlayerPresenter.PlayerState?) {
        super.postValue(value)
    }
    companion object {
        val instance by lazy {
            LiveDataState()
        }
    }
}
