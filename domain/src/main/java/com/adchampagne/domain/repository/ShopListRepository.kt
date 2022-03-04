package com.adchampagne.domain.repository

import androidx.lifecycle.LiveData
import com.adchampagne.domain.ShopItem

interface ShopListRepository {

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun delShopItem(shopItem: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

    suspend fun getShopItem(shopItemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

}