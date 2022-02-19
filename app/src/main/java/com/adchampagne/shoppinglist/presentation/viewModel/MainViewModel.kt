package com.adchampagne.shoppinglist.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.adchampagne.data.repository.ShopListRepositoryImpl
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.useCase.DelShopItemUseCase
import com.adchampagne.domain.useCase.EditShopItemUseCase
import com.adchampagne.domain.useCase.GetShopListUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val delShopItemUseCase = DelShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopListLiveData = getShopListUseCase.execute()

    fun deleteShopItem(shopItem: ShopItem) {
        delShopItemUseCase.execute(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.execute(newItem)
    }
}