package vip.dengwj.myjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vip.dengwj.myjetpack.R
import vip.dengwj.myjetpack.domain.OnSellData

class OnSellListAdapter : RecyclerView.Adapter<OnSellListAdapter.Holder>() {
    private val data = arrayListOf<OnSellData.ListBean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_onsell, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = data[position]
        val title = holder.itemView.findViewById<TextView>(R.id.title)
        title.text = item.title
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(it: List<OnSellData.ListBean>?) {
        data.clear()
        data.addAll(it!!)
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}