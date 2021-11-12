package com.example.kotlin2_21.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2_21.R
import com.example.kotlin2_21.domain.ShopItem

class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.tv_name)
    private val count = itemView.findViewById<TextView>(R.id.tv_count)

    fun onBind(shopItem: ShopItem) {
        name.text = shopItem.name
        count.text = shopItem.count.toString()
    }
}