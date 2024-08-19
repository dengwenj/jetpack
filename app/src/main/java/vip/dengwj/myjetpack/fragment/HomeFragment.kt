package vip.dengwj.myjetpack.fragment

import android.os.Bundle
import android.util.Log
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.base.BaseNavFragment

class HomeFragment : BaseNavFragment() {
    override fun getRootViewId(): Int {
        return R.layout.fragment_home
    }
}