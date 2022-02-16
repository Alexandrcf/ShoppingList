package com.adchampagne.shoppinglist.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adchampagne.data.repository.ShopListRepositoryImpl
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.useCase.DelShopItemUseCase
import com.adchampagne.domain.useCase.EditShopItemUseCase
import com.adchampagne.domain.useCase.GetShopListUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val delShopListUseCase = DelShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopListLiveData = getShopListUseCase.execute()

    fun deleteShopItem(shopItem: ShopItem) {
        delShopListUseCase.execute(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.execute(newItem)
    }
}