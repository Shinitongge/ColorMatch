package com.colormatch.app.ui.analysis

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.colormatch.app.databinding.FragmentColorAnalysisBinding
import com.colormatch.app.ui.analysis.adapter.ColorAnalysisAdapter
import com.colormatch.app.utils.ColorAnalyzer

class ColorAnalysisFragment : Fragment() {
    
    private var _binding: FragmentColorAnalysisBinding? = null
    private val binding get() = _binding!!
    
    private val args: ColorAnalysisFragmentArgs by navArgs()
    private lateinit var colorAdapter: ColorAnalysisAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColorAnalysisBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupUI()
        analyzeColors()
    }
    
    private fun setupUI() {
        // 显示图片
        Glide.with(this)
            .load(args.imagePath)
            .into(binding.imageView)
        
        // 显示分类
        binding.textViewCategory.text = "分类: ${args.category.displayName}"
        
        // 设置RecyclerView
        colorAdapter = ColorAnalysisAdapter()
        binding.recyclerViewColors.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = colorAdapter
        }
    }
    
    private fun analyzeColors() {
        val bitmap = BitmapFactory.decodeFile(args.imagePath)
        val colors = ColorAnalyzer.extractColors(bitmap)
        
        colorAdapter.submitList(colors)
        
        // 显示主要颜色信息
        if (colors.isNotEmpty()) {
            val mainColor = colors.first()
            binding.textViewMainColor.text = "主色调: ${mainColor.colorName} (${String.format("%.1f", mainColor.percentage * 100)}%)"
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}