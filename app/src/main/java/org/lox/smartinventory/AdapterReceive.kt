package org.lox.smartinventory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterReceive (var mContext :Context, var list :MutableList<Inventory>) :
    RecyclerView.Adapter<AdapterReceive.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_receive, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemIdText = itemView.findViewById<TextView>(R.id.receive_text_item)
        val itemDesText = itemView.findViewById<TextView>(R.id.receive_text_des)
        val itemDateText = itemView.findViewById<TextView>(R.id.receive_text_date)
        val itemStockText = itemView.findViewById<TextView>(R.id.receive_text_stock)
        val inputText = itemView.findViewById<EditText>(R.id.receive_text_input)

        fun bind(item :Inventory?){
            apply {
                itemIdText.text = item?.itemID
                itemDesText.text = item?.itemName
//                itemDateText.text = item?.
                itemStockText.text = item?.itemStock
            }
        }
    }
}