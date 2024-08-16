package vip.dengwj.myjetpack.taobao

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.adapter.OnSellListAdapter
import vip.dengwj.myjetpack.base.LoadState
import vip.dengwj.myjetpack.util.ToastUtils

class OnSellActivity : AppCompatActivity() {
    private val onSellViewModel by lazy {
        ViewModelProvider(this)[OnSellViewModel::class.java]
    }

    private val refreshView by lazy {
        findViewById<TwinklingRefreshLayout>(R.id.refreshView)
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.RecyclerView)
    }

    private val loadingView by lazy {
        findViewById<LinearLayout>(R.id.loading)
    }

    private val errorView by lazy {
        findViewById<LinearLayout>(R.id.error)
    }

    private val emptyView by lazy {
        findViewById<LinearLayout>(R.id.empty)
    }

    private val onSellListAdapter by lazy {
        OnSellListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onsell)

        initDataListener()
        initView()
    }

    private fun initView() {
        // 刷新控件
        refreshView.setEnableRefresh(false) // 下拉刷新禁止
        refreshView.setOnRefreshListener(object : RefreshListenerAdapter() {
            override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
                onSellViewModel.loadMore()
            }
        })

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = onSellListAdapter

        // 错误重新点击
        findViewById<ImageView>(R.id.errorimg).setOnClickListener {
            onSellViewModel.loadContent()
        }
    }

    /**
     * 对数据进行监听
     */
    private fun initDataListener() {
        //onSellViewModel.onSellLiveData.observe(this) {
        //    Log.d("pumu", "list -> ${it.size}")
        //}
        onSellViewModel.apply {
            onSellLiveData.observe(this@OnSellActivity) {
                // 第一次加载
                if (loadState.value != LoadState.SUCCESS_MORE) {
                    onSellListAdapter.setData(it)
                } else {
                    // 加载更多成功
                    onSellListAdapter.addData(it)
                }
            }
        }.loadContent()

        // 对状态数据进行监听
        onSellViewModel.run {
            loadState.observe(this@OnSellActivity) {
                hideAll()
                when (it) {
                    LoadState.LOADING -> {
                        loadingView.visibility = View.VISIBLE
                    }
                    LoadState.ERROR -> {
                        errorView.visibility = View.VISIBLE
                    }
                    LoadState.SUCCESS -> {
                        refreshView.visibility = View.VISIBLE
                    }
                    LoadState.EMPTY -> {
                        emptyView.visibility = View.VISIBLE
                    }

                    LoadState.LOADING_MORE -> {
                        refreshView.visibility = View.VISIBLE
                    }

                    LoadState.SUCCESS_MORE -> {
                        refreshView.visibility = View.VISIBLE
                        refreshView.finishLoadmore()
                        ToastUtils.showToast("加载成功")
                    }

                    LoadState.ERROR_MORE -> {
                        refreshView.visibility = View.VISIBLE
                        refreshView.finishLoadmore()
                        ToastUtils.showToast("网络错误，请稍后重试")
                    }
                    LoadState.EMPTY_MORE -> {
                        refreshView.visibility = View.VISIBLE
                        refreshView.finishLoadmore()
                        ToastUtils.showToast("暂无更多数据")
                    }
                }
            }
        }
    }

    //private fun initViewModel() {
    //    onSellViewModel.loadContent()
    //}

    /**
     * 所有的隐藏
     */
    private fun hideAll() {
        refreshView.visibility = View.GONE
        loadingView.visibility = View.GONE
        errorView.visibility = View.GONE
        emptyView.visibility = View.GONE
    }
}