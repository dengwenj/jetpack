package vip.dengwj.myjetpack.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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
            // 以前跳转到 activity 用的 startActivity
            // 跳转到 fragment 用的 replace 或 show、hide
            // 现在用 navigation，在 资源文件里配置 navigation
            val bundle = Bundle()
            bundle.putString(
                "userName",
                view.findViewById<EditText>(R.id.userName).text.toString()
            )
            findNavController().navigate(R.id.to_register_fragment, bundle)
        }
        // 跳转到找回密码
        view.findViewById<Button>(R.id.forget).setOnClickListener {
            findNavController().navigate(R.id.to_forget_fragment)
        }

        view.findViewById<Button>(R.id.agreement).setOnClickListener {
            val bundle = Bundle()
            bundle.putString(
                "userName",
                view.findViewById<EditText>(R.id.userName).text.toString()
            )
            findNavController().navigate(R.id.to_agreement_activity, bundle)
        }
    }
}