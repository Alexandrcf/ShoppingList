package com.adchampagne.domain.useCase

import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun execute(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem = shopItem)
    }
}