package vip.dengwj.myjetpack._databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.databinding.ActivityTemperatureBinding
import vip.dengwj.myjetpack.util.TempSensorType
import vip.dengwj.myjetpack.viewmodel.TemperatureViewModel

class TemperatureActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[TemperatureViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_temperature)
        val binding = DataBindingUtil.setContentView<ActivityTemperatureBinding>(
            this,
            R.layout.activity_temperature
        )

        viewModel.supportTest.observe(this) {
            when (it) {
                TempSensorType.NONE -> {
                    if (!binding.notBodyAndEnv.isInflated) {
                        binding.notBodyAndEnv.viewStub?.inflate()
                    }
                }

                TempSensorType.BODY -> {
                    if (!binding.body.isInflated) {
                        binding.body.viewStub?.inflate()
                    }
                }
                TempSensorType.BODY_ENV -> {
                    if (!binding.bodyAndEnv.isInflated) {
                        binding.bodyAndEnv.viewStub?.inflate()
                    }
                }
            }
        }

        viewModel.bodyVal.observe(this) {
            binding.bodyVal = it
        }

        viewModel.envVal.observe(this) {
            binding.envVal = it
        }
    }
}