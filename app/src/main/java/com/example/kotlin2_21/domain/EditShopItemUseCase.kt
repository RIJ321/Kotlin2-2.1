package com.example.kotlin2_21.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem (shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }

}