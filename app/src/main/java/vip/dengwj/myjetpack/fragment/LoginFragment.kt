package vip.dengwj.myjetpack.fragment

import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseNavFragment

class LoginFragment : BaseNavFragment() {
    override fun getRootViewId(): Int {
        return R.layout.fragment_login
    }

    override fun initView(view: View) {
        // 跳转到注册
        view.findViewById<Button>(R.id.register).setOnClickListener {
            findNavController().navigate(R.id.to_register_fragment)
        }
        // 跳转到找回密码
        view.findViewById<Button>(R.id.forget).setOnClickListener {
            findNavController().navigate(R.id.to_forget_fragment)
        }
    }
}