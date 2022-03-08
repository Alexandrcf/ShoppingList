package com.adchampagne.shoppinglist.di

import android.app.Application

class ShopApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}