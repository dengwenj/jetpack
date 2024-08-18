package vip.dengwj.myjetpack.fragment

import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseNavFragment

class AvatarVerifyFragment : BaseNavFragment() {
    override fun getRootViewId(): Int {
        return R.layout.fragment_avatar_verify
    }

    override fun initView(view: View) {
        view.findViewById<Button>(R.id.toLogin).setOnClickListener {
            findNavController().navigate(R.id.to_login)
        }
    }
}