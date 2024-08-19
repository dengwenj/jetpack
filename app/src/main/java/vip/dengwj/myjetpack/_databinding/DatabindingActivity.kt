package vip.dengwj.myjetpack._databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.databinding.ActivityDatabindingBinding
import vip.dengwj.myjetpack.domain.User

class DatabindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflate = ActivityDatabindingBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        inflate.user = User("朴睦", 24, "男")
    }
}