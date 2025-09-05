package com.colormatch.app.ui.classification

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.colormatch.app.data.model.ClothingCategory
import com.colormatch.app.databinding.FragmentClassificationBinding
import com.colormatch.app.ui.classification.adapter.CategoryAdapter
import com.colormatch.app.ui.classification.ClassificationFragmentArgs
import com.colormatch.app.ui.classification.ClassificationFragmentDirections

class ClassificationFragment : Fragment() {
    
    private var _binding: FragmentClassificationBinding? = null
    private val binding get() = _binding!!
    
    private val args: ClassificationFragmentArgs by navArgs()
    private lateinit var categoryAdapter: CategoryAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassificationBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupUI()
        setupRecyclerView()
    }
    
    private fun setupUI() {
        // 显示拍摄的图片
        Glide.with(this)
            .load(args.imagePath)
            .into(binding.imageView)
    }
    
    private fun setupRecyclerView() {
        categoryAdapter = CategoryAdapter { category ->
            // 跳转到颜色分析页面
            val action = ClassificationFragmentDirections
                .actionClassificationToColorAnalysis(args.imagePath, category)
            findNavController().navigate(action)
        }
        
        binding.recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }
        
        categoryAdapter.submitList(ClothingCategory.values().toList())
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}