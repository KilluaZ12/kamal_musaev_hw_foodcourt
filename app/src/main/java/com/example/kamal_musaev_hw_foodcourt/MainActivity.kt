package com.example.kamal_musaev_hw_foodcourt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamal_musaev_hw_foodcourt.adapter.ButtonAdapter
import com.example.kamal_musaev_hw_foodcourt.adapter.CategoryAdapter
import com.example.kamal_musaev_hw_foodcourt.adapter.FoodAdapter
import com.example.kamal_musaev_hw_foodcourt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  FoodAdapter.OnFoodClickListener {

    lateinit var binding: ActivityMainBinding

    var buttonArrayList: ArrayList<Button> = ArrayList()
    var categoryArrayList: ArrayList<Category> = ArrayList()
    var foodArrayList: ArrayList<Food> = ArrayList()

    lateinit var adapterButton: ButtonAdapter
    lateinit var adapterCategory: CategoryAdapter
    lateinit var adapterFood: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onCreatedButton()
        onCreatedCategory()
        onCreateFood()

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

        adapterCategory = CategoryAdapter(this, categoryArrayList) {

        }
        binding.recyclerViewForCategory.adapter = adapterCategory
    }

    private fun onCreateFood() {
        foodArrayList.add(Food("Burger Craze", R.drawable.burger_for_menu, true,
        601, "American", "15-20 min", "1.5"))
        foodArrayList.add(Food("Vegetarian Pizza", R.drawable.pizza, false,
        784, "Italian", "10-15 min", "0.8"))
        foodArrayList.add(Food("Burger Craze", R.drawable.burger_for_menu, true,
            601, "American", "15-20 min", "1.5"))
        foodArrayList.add(Food("Vegetarian Pizza", R.drawable.pizza, false,
            784, "Italian", "10-15 min", "0.8"))

        adapterFood = FoodAdapter(this, foodArrayList, this)
        binding.recyclerViewForMenu.adapter = adapterFood

    }
    override fun onFoodClick(food: Food) {

        val bundle = Bundle()
        bundle.putParcelable("food", food)
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}