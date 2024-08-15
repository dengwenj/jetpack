package vip.dengwj.myjetpack.player

import android.util.Log
import vip.dengwj.myjetpack.lifecycle.ILifecycle

/**
 * 应该要弄成单列的
 */
class PlayerPresenter private constructor(): IPlayerPresenter, ILifecycle {
    enum class PlayerState {
        NONE, PLAY, PAUSED
    }

    companion object {
        val instance by lazy {
            PlayerPresenter()
        }
    }

    private var currentPlayerState = PlayerState.NONE

    private val list = arrayListOf<IPlayerCallback>()

    val liveDataState = LiveDataState.instance

    /**
     * 播放暂停
     */
    override fun playPaused(who: Int) {
        list.forEach {
            if (it.getId() == who) {
                // 播放
                if (currentPlayerState != PlayerState.PLAY) {
                    it.playered()
                    currentPlayerState = PlayerState.PLAY
                    liveDataState.postValue(PlayerState.PLAY)
                } else {
                    // 暂停
                    it.paused()
                    currentPlayerState = PlayerState.PAUSED
                    liveDataState.postValue(PlayerState.PAUSED)
                }
            }
        }
    }

    /**
     * 上一首
     */
    override fun prev(who: Int) {
        list.forEach {
            if (it.getId() == who) {
                it.preved()
                it.titleChange("上一首歌词")
                it.coverChange("上一张图片")
                it.progressBarChange(0)
            }
        }
    }

    /**
     * 下一首
     */
    override fun next(who: Int) {
        list.forEach {
            if (it.getId() == who) {
                it.nexted()
                it.titleChange("下一首歌词")
                it.coverChange("下一章图片")
                it.progressBarChange(0)
            }
        }
    }

    /**
     * 注册
     */
    fun registerCallback(callback: IPlayerCallback) {
        if (!list.contains(callback)) {
            list.add(callback)
        }
    }

    /**
     * 取消注册
     */
    fun unregisterCallback(callback: IPlayerCallback) {
        list.remove(callback)
    }

    override fun onCreate() {

    }

    override fun onStart() {
        Log.d("pumu", "player onStart")
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {
        Log.d("pumu", "player onStop")
    }

    override fun onDestroy() {

    }
}