package com.example.kamal_musaev_hw_foodcourt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamal_musaev_hw_foodcourt.adapter.ButtonAdapter
import com.example.kamal_musaev_hw_foodcourt.adapter.CategoryAdapter
import com.example.kamal_musaev_hw_foodcourt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var buttonArrayList: ArrayList<Button> = ArrayList()
    var categoryArrayList: ArrayList<Category> = ArrayList()

    lateinit var adapterButton: ButtonAdapter
    lateinit var adapterCategory: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onCreatedButton()
        onCreatedCategory()

    }


    private fun onCreatedButton() {

        buttonArrayList.add(Button(true, R.string.delivery))
        buttonArrayList.add(Button(false, R.string.pickup))
        buttonArrayList.add(Button(false, R.string.catering))
        buttonArrayList.add(Button(false, R.string.curbside))

        adapterButton = ButtonAdapter(this, buttonArrayList) {

        }
        binding.recyclerViewForButton.adapter = adapterButton

    }

    private fun onCreatedCategory() {
        categoryArrayList.add(Category(R.drawable.burger, R.string.takeaways, false))
        categoryArrayList.add(Category(R.drawable.products, R.string.grocery, false))
        categoryArrayList.add(Category(R.drawable.toothbrush, R.string.convenience, false))
        categoryArrayList.add(Category(R.drawable.pills, R.string.pharmacy, false))

        adapterCategory = CategoryAdapter(this, categoryArrayList){

        }
        binding.recyclerViewForCategory.adapter = adapterCategory
    }

}