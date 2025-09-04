package com.colormatch.app.ui.classification.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.colormatch.app.data.model.ClothingCategory
import com.colormatch.app.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val onCategoryClick: (ClothingCategory) -> Unit
) : ListAdapter<ClothingCategory, CategoryAdapter.ViewHolder>(CategoryDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class ViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(category: ClothingCategory) {
            binding.textViewCategory.text = category.displayName
            binding.root.setOnClickListener {
                onCategoryClick(category)
            }
        }
    }
    
    private class CategoryDiffCallback : DiffUtil.ItemCallback<ClothingCategory>() {
        override fun areItemsTheSame(oldItem: ClothingCategory, newItem: ClothingCategory): Boolean {
            return oldItem == newItem
        }
        
        override fun areContentsTheSame(oldItem: ClothingCategory, newItem: ClothingCategory): Boolean {
            return oldItem == newItem
        }
    }
}