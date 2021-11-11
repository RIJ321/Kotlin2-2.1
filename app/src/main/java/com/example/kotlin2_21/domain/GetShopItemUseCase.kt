package com.example.kotlin2_21.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
        return  shopListRepository.getShopItem(shopItemId
        )
    }

}