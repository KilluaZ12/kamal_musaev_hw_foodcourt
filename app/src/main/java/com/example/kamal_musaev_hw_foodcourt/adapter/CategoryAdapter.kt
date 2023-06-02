package com.example.kamal_musaev_hw_foodcourt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.kamal_musaev_hw_foodcourt.Category
import com.example.kamal_musaev_hw_foodcourt.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val context: Context,
    private val categoryList: ArrayList<Category>,
    var onClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var previousSelectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(categoryList[position], previousSelectedPosition)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(category: Category, selectedPosition: Int) {
            binding.label.setText(category.text)
            binding.itemCategory.setImageResource(category.image)

            val isSelected = adapterPosition == selectedPosition
            binding.underline.isVisible = isSelected

            binding.root.setOnClickListener {
                val previousSelected = previousSelectedPosition
                val clickedPosition = adapterPosition

                previousSelectedPosition = clickedPosition

                if (previousSelected != RecyclerView.NO_POSITION) {
                    notifyItemChanged(previousSelected)
                }

                notifyItemChanged(clickedPosition)

                onClick(category)
            }
        }
    }
}