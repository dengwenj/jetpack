package vip.dengwj.myjetpack.player

interface IPlayerCallback {
    /**
     * 播放
     */
    fun playered()

    /**
     * 暂停
     */
    fun paused()

    /**
     * 上一首
     */
    fun preved()

    /**
     * 下一首
     */
    fun nexted()

    /**
     * 标题改变
     */
    fun titleChange(title: String)

    /**
     * 进度条改变
     */
    fun progressBarChange(current: Int)

    /**
     * 封面变化
     */
    fun coverChange(cover: String)

    /**
     * 获取是哪个的
     */
    fun getId(): Int
}