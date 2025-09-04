package com.colormatch.app.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.colormatch.app.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
    }
    
    private fun setupRecyclerView() {
        binding.recyclerViewGallery.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            // TODO: 设置适配器显示保存的服饰图片
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}