package vip.dengwj.myjetpack.taobao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class RecommendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recommendViewModel = ViewModelProvider(this)[RecommendViewModel::class.java]

    }
}