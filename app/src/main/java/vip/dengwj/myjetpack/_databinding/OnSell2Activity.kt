package vip.dengwj.myjetpack._databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.fragment.OnSellFragment2
import vip.dengwj.myjetpack.fragment.TestDataFragment

class OnSell2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_sell2)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.test_data, TestDataFragment())
        transaction.add(R.id.onSellFragment, OnSellFragment2())
        transaction.commit()
    }
}