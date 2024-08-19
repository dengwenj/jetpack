package vip.dengwj.myjetpack.navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import vip.dengwj.myjetpack.R

class TabbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbar)

        val findFragmentById = supportFragmentManager.findFragmentById(R.id.taobao_bar) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(findFragmentById.navController)
        // 换成 fragment 标签
        //findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(findNavController(R.id.taobao_bar))
    }
}