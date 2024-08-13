package vip.dengwj.myjetpack.player

interface IPlayerPresenter {
    // 播放暂停
    fun playPaused(who: Int)

    // 上一首
    fun prev(who: Int)

    // 下一首
    fun next(who: Int)
}