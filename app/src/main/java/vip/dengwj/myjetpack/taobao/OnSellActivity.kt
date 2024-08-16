package vip.dengwj.myjetpack.taobao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.adapter.OnSellListAdapter

class OnSellActivity : AppCompatActivity() {
    private val onSellViewModel by lazy {
        ViewModelProvider(this)[OnSellViewModel::class.java]
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.RecyclerView)
    }

    private val onSellListAdapter by lazy {
        OnSellListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onsell)

        initDataListener()
        initView()
        //initViewModel()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = onSellListAdapter
    }

    private fun initDataListener() {
        //onSellViewModel.onSellLiveData.observe(this) {
        //    Log.d("pumu", "list -> ${it.size}")
        //}
        onSellViewModel.apply {
            onSellLiveData.observe(this@OnSellActivity) {
                onSellListAdapter.setData(it)
            }
        }.loadContent()
    }

    //private fun initViewModel() {
    //    onSellViewModel.loadContent()
    //}
}