package com.example.viewpager2transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager2transition.databinding.ActivityMainBinding
import com.example.viewpager2transition.models.ShoppingItem
import com.example.viewpager2transition.page_transformers.DepthPageTransformers
import com.example.viewpager2transition.page_transformers.ZoomOutTransformers

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null

    lateinit var sample_data:MutableList<ShoppingItem>

    lateinit var myadapter:ItemListsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setupSampleData()
        setupAdapterAndData()
    }


    override fun onDestroy() {

        super.onDestroy()
        binding=null

    }


    fun setupSampleData(){

        sample_data= mutableListOf<ShoppingItem>()
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.tshirt_item,item_name = "tshirt",item_price = "40$"))
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.boar_image,item_name = "boat earbuds",item_price = "10$"))
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.cap,item_name = "cap",item_price = "05$"))
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.shoes,item_name = "puma shoes",item_price = "10$"))
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.jacket,item_name = "jacket",item_price = "40$"))
        sample_data.add(ShoppingItem(item_photo_resource = R.drawable.tshirt2,item_name = "tshirt2",item_price = "70$"))


    }


    fun setupAdapterAndData(){

        myadapter= ItemListsAdapter()
        myadapter.differ.submitList(sample_data)
        binding!!.shoppingItems.adapter=myadapter
//        binding!!.shoppingItems.setPageTransformer(ZoomOutTransformers()) //ZOOM OUT FEATURE
        binding!!.shoppingItems.setPageTransformer(DepthPageTransformers())
    }

}