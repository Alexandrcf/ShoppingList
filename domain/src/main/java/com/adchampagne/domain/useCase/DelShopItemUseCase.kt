package com.adchampagne.domain.useCase

import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository

class DelShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun execute(shopItem: ShopItem) {
        shopListRepository.delShopItem(shopItem = shopItem)
    }
}