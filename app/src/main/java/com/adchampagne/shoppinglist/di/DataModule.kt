package com.adchampagne.shoppinglist.di

import android.app.Application
import com.adchampagne.data.repository.ShopListRepositoryImpl
import com.adchampagne.data.room.AppDatabase
import com.adchampagne.data.room.ShopListDao
import com.adchampagne.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}