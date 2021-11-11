package com.example.kotlin2_21.presentation

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2_21.databinding.ShopItemRvBinding
import com.example.kotlin2_21.domain.ShopItem

class MainAdapter(
    private val list: List<ShopItem>,
    private val itemListener: ItemListener
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var binding: ShopItemRvBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ShopItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(binding: ShopItemRvBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(shopItem: ShopItem) {
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()

            binding.root.setOnClickListener {
                if (shopItem.enable) {
                    binding.root.setBackgroundColor(Color.DKGRAY)
                    itemListener.changeItemEnable(shopItem, adapterPosition)
                    itemListener.changeColor(Color.DKGRAY, binding.container)
                } else {
                    itemListener.changeUnable(shopItem, adapterPosition)
                }
            }
        }
    }

    interface ItemListener {

        fun changeItemEnable(shopItem: ShopItem, position: Int)

        fun changeUnable(shopItem: ShopItem, position: Int)

        fun changeColor(color: Int, view: View)

        fun message(message: String)

    }

}