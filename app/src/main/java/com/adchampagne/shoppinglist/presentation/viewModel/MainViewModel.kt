package com.adchampagne.shoppinglist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.useCase.DelShopItemUseCase
import com.adchampagne.domain.useCase.EditShopItemUseCase
import com.adchampagne.domain.useCase.GetShopListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase: GetShopListUseCase,
    private val delShopItemUseCase: DelShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
) : ViewModel() {

    val shopListLiveData = getShopListUseCase.execute()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            delShopItemUseCase.execute(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.execute(newItem)
        }
    }
}