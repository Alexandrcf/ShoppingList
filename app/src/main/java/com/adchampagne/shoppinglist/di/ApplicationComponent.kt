package com.adchampagne.shoppinglist.di

import android.app.Application
import com.adchampagne.shoppinglist.presentation.activity.MainActivity
import com.adchampagne.shoppinglist.presentation.fragments.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}