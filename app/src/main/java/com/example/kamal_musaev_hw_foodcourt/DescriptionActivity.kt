package com.example.kamal_musaev_hw_foodcourt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.kamal_musaev_hw_foodcourt.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDescriptionBinding
    lateinit var food: Food


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val foodArrayList = bundle?.getParcelableArrayList<Food>("food")
        val selectedFood = foodArrayList?.get(0)
        setViews()
    }

    private fun setViews() {
        binding.textViewTitle.text = food.title
        binding.imageViewForMenu.setImageResource(food.image)
        binding.textViewParticipants.text = food.parts.toString()
        binding.textViewPlace.text = food.place
        binding.buttonTime.text = food.place
        binding.textViewDistance.text = food.distance
        setDiscount()
    }

    private fun setDiscount() {
        if(food.discount) {
            binding.textViewDiscount.visibility = RecyclerView.VISIBLE
        } else {
            binding.textViewDiscount.visibility = RecyclerView.GONE
        }
    }
}