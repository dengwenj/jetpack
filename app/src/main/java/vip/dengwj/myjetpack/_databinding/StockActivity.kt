package vip.dengwj.myjetpack._databinding

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.databinding.ActivityStockBinding
import vip.dengwj.myjetpack.viewmodel.StockViewModel

class StockActivity : AppCompatActivity() {

    private val stockViewModel by lazy {
        ViewModelProvider(this)[StockViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        val binding = DataBindingUtil.setContentView<ActivityStockBinding>(
            this,
            R.layout.activity_stock
        )

        // UI 变化去通知数据变化
        binding.viewModel = stockViewModel
        // 才会数据变化去通知 UI 变化
        binding.lifecycleOwner = this
        // 当前股价数据变动
        stockViewModel.currentSocket.observe(this) {
            stockViewModel.updateTotal()
        }

        // 数量数据变动
        stockViewModel.socketCount.observe(this) {
            stockViewModel.updateTotal()
        }

        // 同意协议
        stockViewModel.agreement.observe(this) {
            Log.d("pumu", "agreement -> $it")
        }
    }

    // 数据变化去通知 UI 变化
    // 点击卖出
    fun handleClick(view: View) {
        stockViewModel.currentSocket.value = "22"
        stockViewModel.agreement.value = true
    }
}