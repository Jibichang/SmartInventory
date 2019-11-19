package org.lox.smartinventory

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class AdapterInventory (var mContext :Context, var list :MutableList<Inventory>)
    :RecyclerView.Adapter<AdapterInventory.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.list_inv, parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.stockItem.setOnClickListener {
            val rnd = list[position].predict.toInt()
            holder.stockItem.text = rnd.toString()
            holder.stockItem.setTextColor(Color.GRAY)
//            colorStock(list[position].itemStock.toInt(), rnd, holder.stockItem)
            Handler().postDelayed(Runnable {
                holder.stockItem.text = list[position].itemStock
                colorStock(list[position].itemStock.toInt(), rnd, holder.stockItem)
            }, 3000)

        }

        holder.layout.setOnClickListener {
            view : View -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(list[position].itemID))
            Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_detailFragment)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idItem = itemView.findViewById<TextView>(R.id.text_id)
        val nameItem = itemView.findViewById<TextView>(R.id.text_name)
        val stockItem = itemView.findViewById<TextView>(R.id.text_stock)
        val layout = itemView.findViewById<ConstraintLayout>(R.id.layout_item)

        fun bind(inv :Inventory?){
            itemView.apply {
                idItem.text = inv?.itemID
                nameItem.text = inv?.itemName
                stockItem.text = inv?.itemStock

                if (inv?.itemStock!!.toInt() < inv.predict.toInt()){
//                    imageStatus.setImageResource(R.drawable.dewarehouse)
                    stockItem.setTextColor(Color.RED)
                } else {
                    stockItem.setTextColor(Color.BLACK)
//                    imageStatus.setImageResource(R.drawable.inwarehouse)
                }
            }
        }
    }

    private fun colorStock(number :Int, numberpre :Int, view :TextView){
        if (number < numberpre){
            view.setTextColor(Color.RED)
        } else {
            view.setTextColor(Color.BLACK)
        }
    }
}
