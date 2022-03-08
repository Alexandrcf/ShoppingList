package com.adchampagne.shoppinglist.di

import androidx.lifecycle.ViewModel
import com.adchampagne.shoppinglist.presentation.viewModel.MainViewModel
import com.adchampagne.shoppinglist.presentation.viewModel.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemViewModel): ViewModel
}