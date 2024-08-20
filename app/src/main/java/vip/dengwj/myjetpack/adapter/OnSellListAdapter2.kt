package vip.dengwj.myjetpack.adapter

import android.graphics.Paint
import android.util.Log
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
        val itemData = list[position]
        holder.binding.itemData = itemData
        holder.binding.oldPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG

        holder.binding.eventHandler = EventHandler(itemData)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(it: List<OnSellData.ListBean>) {
        list.clear()
        list.addAll(it)
        notifyDataSetChanged()
    }

    inner class EventHandler(private val itemData: OnSellData.ListBean) {
        fun handleItemClick(itemView: View) {
            Log.d("pumu", "itemView -> $itemView title ${itemData.title}")
        }

        fun handleItemClick(itemView: View, title: String) {
            Log.d("pumu", "title -> $title")
        }

        fun handleLongClick(title: String): Boolean {
            Log.d("pumu", "title -> $title")
            return true
        }
    }
}