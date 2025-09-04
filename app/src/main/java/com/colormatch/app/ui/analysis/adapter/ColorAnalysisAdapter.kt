package com.colormatch.app.ui.analysis.adapter

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.colormatch.app.R
import com.colormatch.app.data.model.ColorAnalysis
import com.colormatch.app.databinding.ItemColorAnalysisBinding

class ColorAnalysisAdapter : ListAdapter<ColorAnalysis, ColorAnalysisAdapter.ViewHolder>(ColorDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemColorAnalysisBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class ViewHolder(
        private val binding: ItemColorAnalysisBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(colorAnalysis: ColorAnalysis) {
            binding.textViewColorName.text = colorAnalysis.colorName
            binding.textViewPercentage.text = "${String.format("%.1f", colorAnalysis.percentage * 100)}%"
            
            // 设置颜色圆形显示
            val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.circle_color) as GradientDrawable
            drawable.setColor(colorAnalysis.color)
            binding.viewColor.background = drawable
            
            // 设置进度条
            binding.progressBar.progress = (colorAnalysis.percentage * 100).toInt()
        }
    }
    
    private class ColorDiffCallback : DiffUtil.ItemCallback<ColorAnalysis>() {
        override fun areItemsTheSame(oldItem: ColorAnalysis, newItem: ColorAnalysis): Boolean {
            return oldItem.color == newItem.color
        }
        
        override fun areContentsTheSame(oldItem: ColorAnalysis, newItem: ColorAnalysis): Boolean {
            return oldItem == newItem
        }
    }
}