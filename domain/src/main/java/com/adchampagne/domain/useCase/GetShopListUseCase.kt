package com.adchampagne.domain.useCase

import androidx.lifecycle.LiveData
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun execute(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}