package com.adchampagne.domain.useCase

import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun execute(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId = shopItemId)
    }
}