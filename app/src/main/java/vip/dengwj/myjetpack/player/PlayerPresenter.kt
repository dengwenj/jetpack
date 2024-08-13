package vip.dengwj.myjetpack.player

/**
 * 应该要弄成单列的
 */
class PlayerPresenter : IPlayerPresenter {
    enum class PlayerState {
        NONE, PLAY, PAUSED
    }

    private var currentPlayerState = PlayerState.NONE

    private val list = arrayListOf<IPlayerCallback>()

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
                } else {
                    // 暂停
                    it.paused()
                    currentPlayerState = PlayerState.PAUSED
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
}