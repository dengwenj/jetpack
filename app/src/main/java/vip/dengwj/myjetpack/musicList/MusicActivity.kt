package vip.dengwj.myjetpack.musicList

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vip.dengwj.myjetpack.R

class MusicActivity : AppCompatActivity() {
    // 注册 presenter
    private val musicPresenter = MusicPresenter()

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