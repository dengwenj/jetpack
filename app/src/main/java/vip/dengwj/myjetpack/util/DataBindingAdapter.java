package vip.dengwj.myjetpack.util;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DataBindingAdapter {
    @BindingAdapter({"android:setText", "android:setHH"})
    public static void setText(TextView textView, String text, String textHH) {
        // 做一系列事情
        Log.d("pumu", "textHH -> " + textHH);
        Log.d("pumu", "text -> " + text);
        String format = String.format("原价：%.2f", Float.valueOf(text));
        textView.setText(format);
        textView.setPaintFlags(TextView.SYSTEM_UI_LAYOUT_FLAGS);
    }

    @BindingAdapter("goodsImg")
    public static void setUpImg(ImageView iv, String goodsImg) {
        if (goodsImg != null) {
            Glide.with(iv.getContext()).load("https:" + goodsImg).into(iv);
        } else {
            // 默认图片
        }
    }
}
