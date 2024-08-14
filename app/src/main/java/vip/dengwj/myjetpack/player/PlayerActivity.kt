package vip.dengwj.myjetpack.player

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseActivity

class PlayerActivity : BaseActivity(), IPlayerCallback {
    companion object {
        private val PUMU = "pumu"
    }

    private val title by lazy {
        findViewById<TextView>(R.id.title)
    }

    private val img by lazy {
        findViewById<ImageView>(R.id.img)
    }

    private val prev by lazy {
        findViewById<Button>(R.id.prev)
    }

    private val playPaused by lazy {
        findViewById<Button>(R.id.playPaused)
    }

    private val next by lazy {
        findViewById<Button>(R.id.next)
    }

    private val playerPresenter by lazy {
        PlayerPresenter.instance
    }

    init {
         lifecycleProvider.addLifeListener(playerPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        initPresenter()

        initListener()
    }

    private fun initPresenter() {
        playerPresenter.registerCallback(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        playerPresenter.unregisterCallback(this)
    }

    private fun initListener() {
        // 上一首
        prev.setOnClickListener {
            playerPresenter.prev(Utils.page)
        }

        // 播放暂停
        playPaused.setOnClickListener {
            playerPresenter.playPaused(Utils.page)
        }

        // 下一首
        next.setOnClickListener {
            playerPresenter.next(Utils.page)
        }
    }

    override fun playered() {
        this.playPaused.text = "暂停"
    }

    override fun paused() {
        this.playPaused.text = "播放"
    }

    override fun preved() {
        Log.d(PUMU, "播放了上一首歌曲")
    }

    override fun nexted() {
        Log.d(PUMU, "播放了下一首歌曲")
    }

    override fun titleChange(title: String) {
        this.title.text = title
    }

    override fun progressBarChange(current: Int) {
        Log.d(PUMU, "进度条 -> $current")
    }

    override fun coverChange(cover: String) {
        Log.d(PUMU, "cover -> $cover ")
    }

    override fun getId(): Int {
        return Utils.page
    }
}