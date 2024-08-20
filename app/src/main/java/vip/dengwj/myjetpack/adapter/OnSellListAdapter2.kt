package vip.dengwj.myjetpack.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vip.dengwj.myjetpack.databinding.ItemOnSell2Binding
import vip.dengwj.myjetpack.domain.OnSellData

class OnSellListAdapter2 : RecyclerView.Adapter<OnSellListAdapter2.Holder>() {
    private val list = arrayListOf<OnSellData.ListBean>()

    companion object {
        @JvmStatic
        @BindingAdapter("goodsImg")
        fun setUpImg(iv: ImageView, goodsImg: String?) {
            if (goodsImg != null) {
                Glide.with(iv.context).load("https:$goodsImg").into(iv)
            } else {
                // 默认图片
            }
        }
    }

    class Holder(itemView: View, val binding: ItemOnSell2Binding) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemOnSell2Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Holder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 绑定数据，需要得到 binding
        holder.binding.itemData = list[position]
        holder.binding.oldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(it: List<OnSellData.ListBean>) {
        list.clear()
        list.addAll(it)
        notifyDataSetChanged()
    }
}