package com.example.kotlin2_21.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlin2_21.domain.ShopItem


class ShopItemDiffCallback : DiffUtil.ItemCallback<ShopItem>() {

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean =
        (oldItem == newItem)

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean =
        (oldItem == newItem)

}