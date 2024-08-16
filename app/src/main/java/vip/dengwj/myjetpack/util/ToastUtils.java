package vip.dengwj.myjetpack.util;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import vip.dengwj.myjetpack.App;
import vip.dengwj.myjetpack.R;

public class ToastUtils {
    private static Toast toast;

    public static void showToast(String msg) {
        if (toast == null) {
            toast = new Toast(App.context);
        }
        // 自定义 Toast
        toast.setGravity(Gravity.CENTER, 0, 0);
        View view = LayoutInflater.from(App.context).inflate(R.layout.toast_msg, null);
        TextView textView = view.findViewById(R.id.msg);
        textView.setText(msg);
        toast.setView(view);
        toast.show();
    }
}