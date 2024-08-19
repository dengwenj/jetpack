package vip.dengwj.myjetpack._databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.databinding.ActivityDatabindingBinding
import vip.dengwj.myjetpack.domain.User

class DatabindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 第一种方式
        //val binding = ActivityDatabindingBinding.inflate(layoutInflater)
        val binding = DataBindingUtil.setContentView<ActivityDatabindingBinding>(
            this,
            R.layout.activity_databinding
        )
        // 第二种方式可以不用自己写 setContentView
        //setContentView(binding.root)
        binding.user = User("朴睦", 24, "男")
    }
}