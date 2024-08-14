package vip.dengwj.myjetpack.musicList

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseActivity

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

    private fun initDataListener() {
        musicPresenter.musicList.addListener {
            sizeText.text = "总 ${it.size} 条"
        }

        musicPresenter.musicState.addListener {
            Log.d("pumu", "状态 -> $it")
        }
    }

    private fun initViewListener() {
        findViewById<Button>(R.id.btn).setOnClickListener {
            musicPresenter.getMusic()
        }
    }
}