package com.adchampagne.domain.useCase

import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    suspend fun execute(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId = shopItemId)
    }
}