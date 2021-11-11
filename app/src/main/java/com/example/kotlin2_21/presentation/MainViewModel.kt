package com.example.kotlin2_21.presentation

import androidx.lifecycle.ViewModel
import com.example.kotlin2_21.data.ShopListRepositoryImpl
import com.example.kotlin2_21.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun getItem(id: Int): ShopItem {
        return getShopItemUseCase.getShopItem(id)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)
    }

}