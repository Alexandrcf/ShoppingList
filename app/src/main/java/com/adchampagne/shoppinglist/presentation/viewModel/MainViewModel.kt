package com.adchampagne.shoppinglist.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adchampagne.data.repository.ShopListRepositoryImpl
import com.adchampagne.domain.ShopItem
import com.adchampagne.domain.useCase.DelShopItemUseCase
import com.adchampagne.domain.useCase.EditShopItemUseCase
import com.adchampagne.domain.useCase.GetShopListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val delShopItemUseCase = DelShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

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