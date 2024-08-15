package vip.dengwj.myjetpack.musicList

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import vip.dengwj.myjetpack.lifecycle.ILifecycle
import vip.dengwj.myjetpack.musicList.domain.Music

// LifecycleOwner 官方的
class MusicPresenter(owner: LifecycleOwner) : ILifecycle {
    enum class GetMusicState {
        LOADING, EMPTY, SUCCESS, ERROR
    }

    val musicList = DataListenerContainer<List<Music>>()
    val musicState = DataListenerContainer<GetMusicState>()

    private val musicModel by lazy {
        MusicModel()
    }

    private val viewLifeImpl by lazy {
        ViewLifeImpl()
    }

    init {
//        owner.getLifecycleProvider1().addLifeListener(this)
        owner.lifecycle.addObserver(viewLifeImpl)
    }

    /**
     * 被动通知 View 层的生命周期变化
     */
    inner class ViewLifeImpl : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event)  {
                Lifecycle.Event.ON_START -> {
                    Log.d("pumu", "start哈哈哈")
                }
                Lifecycle.Event.ON_DESTROY -> {
                    Log.d("pumu", "销毁了哈哈哈")
                }
                else -> {

                }
            }
        }

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
        Log.d("pumu", "onStart")
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {
        Log.d("pumu", "onStop")
    }

    override fun onDestroy() {

    }
}