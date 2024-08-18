package vip.dengwj.myjetpack.fragment

import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseNavFragment

class RegisterFragment : BaseNavFragment() {
    override fun getRootViewId(): Int {
        return R.layout.fragment_register
    }

    override fun initView(view: View) {
        view.findViewById<Button>(R.id.register_back).setOnClickListener {
            findNavController().navigateUp()
            //findNavController().popBackStack()
        }

        view.findViewById<Button>(R.id.toAvatarVerify).setOnClickListener {
            findNavController().navigate(R.id.to_avatar_verify)
        }
    }
}