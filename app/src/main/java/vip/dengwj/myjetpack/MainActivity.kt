package vip.dengwj.myjetpack

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), UserModel.OnLoginState {
    private lateinit var btn: Button
    // 允许你延迟初始化一个属性直到它首次被访问
    private val account by lazy {
        findViewById<EditText>(R.id.account)
    }
    private val password by lazy {
        findViewById<EditText>(R.id.password)
    }

    private val userModel by lazy {
        UserModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.loginBtn)

        initListener()
    }

    private fun initListener() {
        btn.setOnClickListener {
            // 去登录
            goLogin()
        }
    }

    private fun goLogin() {
        // 做登录的逻辑处理
        val account = account.text.toString()
        val toString = password.text.toString()
        // 检查账号格式是否正确
        // 检查密码长度是否正确
        // 进行登录
        userModel.doLogin(this)
    }

    override fun loading() {
        Log.d("pumu", "加载中...")
    }

    override fun success() {
        Log.d("pumu", "登录成功")
    }

    override fun failed() {
        Log.d("pumu", "登录失败")
    }
}