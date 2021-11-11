package com.example.kotlin2_21.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var enable: Boolean,
    var id: Int = UNDEFINED_ID

) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}