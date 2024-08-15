package vip.dengwj.myjetpack.musicList

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseActivity
import vip.dengwj.myjetpack.musicList.domain.Music

/**
 * Activity 生命周期：
 * onCreate - 创建 -- 还不可见
 * onStart - 可见 -- 还不可以交互
 * onResume - 可见 -- 可以交互
 * onPause - 可见 -- 不可以交互
 * onStop - 不可见 -- 不可以交互
 * onDestroy - 销毁 -- 不可见
 */
class MusicActivity : BaseActivity() {
    private lateinit var foreverObserver: ForeverObserver

    // 注册 presenter
    private val musicPresenter = MusicPresenter(this)

    private val sizeText by lazy {
        findViewById<TextView>(R.id.size)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_list)

        initDataListener()
        initViewListener()
    }

    inner class ForeverObserver : Observer<List<Music>> {
        override fun onChanged(value: List<Music>) {
            Log.d("pumu", "ForeverObserver onChanged")
            sizeText.text = "总 ${value.size} 条"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPresenter.liveDataMusic.removeObserver(foreverObserver)
    }

    private fun initDataListener() {
        foreverObserver = ForeverObserver()

        musicPresenter.liveDataMusic.observeForever(foreverObserver)
//        musicPresenter.liveDataMusic.observe(this) {
//            sizeText.text = "总 ${it.size} 条"
//        }

//        musicPresenter.musicList.addListener(this) {
//            sizeText.text = "总 ${it.size} 条"
//        }

        musicPresenter.musicState.addListener(this) {
            Log.d("pumu", "状态 -> $it")
        }
    }

    private fun initViewListener() {
        findViewById<Button>(R.id.btn).setOnClickListener {
            musicPresenter.getMusic()
        }
    }
}