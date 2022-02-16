package com.adchampagne.shoppinglist.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adchampagne.shoppinglist.R
import com.adchampagne.shoppinglist.presentation.viewModel.MainViewModel
import androidx.activity.viewModels
import com.adchampagne.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.shopListLiveData.observe(this) {
            Log.d("MyLogs", it.toString())
        }

    }
}