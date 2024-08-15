package vip.dengwj.myjetpack.taobao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import vip.dengwj.myjetpack.R

class OnSellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onsell)

        val recommendViewModel = ViewModelProvider(this)[OnSellViewModel::class.java]
    }
}