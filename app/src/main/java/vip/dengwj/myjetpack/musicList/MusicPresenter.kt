package vip.dengwj.myjetpack.musicList

import vip.dengwj.myjetpack.lifecycle.ILifecycle
import vip.dengwj.myjetpack.musicList.domain.Music

class MusicPresenter : ILifecycle {
    enum class GetMusicState {
        LOADING, EMPTY, SUCCESS, ERROR
    }

    val musicList = DataListenerContainer<List<Music>>()
    val musicState = DataListenerContainer<GetMusicState>()

    private val musicModel by lazy {
        MusicModel()
    }

    fun getMusic() {
        // 加载中
        musicState.value = GetMusicState.LOADING

        musicModel.getMusicList(1, 10, object : MusicModel.OnGetMusicListener {
            override fun onSuccess(list: List<Music>) {
                musicState.value = if (list.isEmpty()) {
                    GetMusicState.EMPTY
                } else {
                    musicList.value = list
                    GetMusicState.SUCCESS
                }
            }

            override fun onError(msg: String) {
                musicState.value = GetMusicState.ERROR
            }
        })
    }

    override fun onCreate() {

    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }
}