package com.example.kotlin2_21.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin2_21.databinding.ActivityMainBinding
import com.example.kotlin2_21.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

/*
        viewModel.shopList.observe(this) {
            Log.e("MainActivityTest", "MainActivity: $it")
        }
*/

        viewModel.deleteShopItem(viewModel.getItem(0))

//        viewModel.changeEnableState(viewModel.getItem(6))

        viewModel.shopList.observe(this) {

            binding.mainRv.adapter = MainAdapter(it, object : MainAdapter.ItemListener {

                override fun changeItemEnable(shopItem: ShopItem, position: Int) {
                    Log.e("TAG", "ENABLE: $shopItem ")
                    viewModel.changeEnableState(it[position])
                }

                override fun changeUnable(shopItem: ShopItem, position: Int) {
                    Log.e("TAG", "UNABLE: $shopItem ")
                    viewModel.changeEnableState(it[position])
                }

                override fun message(message: String) {
//                    Log.e("TAG", message)
                }

                override fun changeColor(color: Int, view: View) {
                    view.setBackgroundColor(color)
                }
            })
        }
    }
}