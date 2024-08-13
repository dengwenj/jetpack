package vip.dengwj.myjetpack

import android.os.Handler

class UserModel {
    // 来登录
    fun doLogin(onLoginState: OnLoginState) {
        // 加载中
        onLoginState.loading()
        // 登录成功
        onLoginState.success()
        // 登录失败
        onLoginState.failed()
        // 需要通知回去 cb
    }

    interface OnLoginState {
        fun loading()

        fun success()

        fun failed()
    }
}