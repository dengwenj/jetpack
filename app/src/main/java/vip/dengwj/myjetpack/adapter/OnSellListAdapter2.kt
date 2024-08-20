package vip.dengwj.myjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vip.dengwj.myjetpack.databinding.ItemOnSell2Binding

class OnSellListAdapter2 : RecyclerView.Adapter<OnSellListAdapter2.Holder>() {
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemOnSell2Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}