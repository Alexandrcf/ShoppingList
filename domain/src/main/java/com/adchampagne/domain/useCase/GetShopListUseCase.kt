package com.adchampagne.domain.useCase

import androidx.lifecycle.LiveData
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopListUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    fun execute(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}