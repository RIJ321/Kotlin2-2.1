package com.example.kotlin2_21.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2_21.R
import com.example.kotlin2_21.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopItemViewHolder>() {

    var recycled = 0
    var shopList = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(shopList,value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    var onShopClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
//        Log.e("recycled", "onCreateViewHolder: ${recycled++}")
        val layout = when (viewType) {
            VIEW_TYPE_ENABLE -> R.layout.shop_item_enable
            VIEW_TYPE_DISABLE -> R.layout.shop_item_disable
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        return ShopItemViewHolder(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(shopList[position])
        holder.itemView.setOnClickListener {
            onShopClickListener?.invoke(shopList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enable) {
            VIEW_TYPE_ENABLE
        } else {
            VIEW_TYPE_DISABLE
        }
    }

    override fun onViewRecycled(holder: ShopItemViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int = shopList.size

    companion object {
        const val VIEW_TYPE_ENABLE = 0
        const val VIEW_TYPE_DISABLE = 1
        const val MAX_VIEW_SIZE = 15
    }
}