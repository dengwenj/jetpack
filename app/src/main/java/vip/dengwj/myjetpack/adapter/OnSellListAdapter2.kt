package vip.dengwj.myjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vip.dengwj.myjetpack.databinding.ItemOnSell2Binding
import vip.dengwj.myjetpack.domain.OnSellData

class OnSellListAdapter2 : RecyclerView.Adapter<OnSellListAdapter2.Holder>() {
    private val list = arrayListOf<OnSellData.ListBean>()

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