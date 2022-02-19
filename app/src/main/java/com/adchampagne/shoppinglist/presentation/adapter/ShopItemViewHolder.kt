package com.adchampagne.shoppinglist.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adchampagne.shoppinglist.R

class ShopItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    val tvCount = itemView.findViewById<TextView>(R.id.tv_count)
}