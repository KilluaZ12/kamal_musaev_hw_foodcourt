package com.example.kamal_musaev_hw_foodcourt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.GONE
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kamal_musaev_hw_foodcourt.Food
import com.example.kamal_musaev_hw_foodcourt.databinding.ItemMenuBinding

class FoodAdapter(
    private val context: Context,
    private val foodArrayList: ArrayList<Food>,
    private val onFoodClickListener: OnFoodClickListener
) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return foodArrayList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.onBind(foodArrayList[position])
    }

    inner class FoodViewHolder(private val binding: ItemMenuBinding) : ViewHolder(binding.root) {
        private val title: TextView = binding.textViewTitle
        private val image: ImageView = binding.imageViewForMenu
        private val discount: TextView = binding.textViewDiscount
        private val parts: TextView = binding.textViewParticipants
        private val place: TextView = binding.textViewPlace
        private val time: TextView = binding.buttonTime
        private val distance: TextView = binding.textViewDistance

        fun onBind(food: Food) {
            title.text = food.title
            image.setImageResource(food.image)
            parts.text = food.parts.toString()
            place.text = food.place
            time.text = food.time
            distance.text = food.distance
            setDiscount(food)

            binding.root.setOnClickListener {
                onFoodClickListener.onFoodClick(food)
            }
        }

        private fun setDiscount(food: Food) {
            if (food.discount) {
                discount.visibility = VISIBLE
            } else {
                discount.visibility = GONE
            }
        }
    }

    interface OnFoodClickListener {
        fun onFoodClick(food: Food)
    }
}