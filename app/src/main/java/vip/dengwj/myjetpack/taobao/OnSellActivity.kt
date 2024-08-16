package vip.dengwj.myjetpack.taobao

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import vip.dengwj.myjetpack.R

class OnSellActivity : AppCompatActivity() {
    private val onSellViewModel by lazy {
        ViewModelProvider(this)[OnSellViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onsell)

        initDataListener()
        initViewModel()
    }

    private fun initDataListener() {
        onSellViewModel.onSellLiveData.observe(this) {
            Log.d("pumu", "list -> ${it.size}")
        }
    }

    private fun initViewModel() {
        onSellViewModel.loadContent()
    }
}