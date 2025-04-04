package com.vigelos.piontest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vigelos.piontest.R
import com.vigelos.piontest.databinding.FragmentArticleBinding
import com.vigelos.piontest.databinding.FragmentGalleryBinding
import com.vigelos.piontest.viewmodel.NewFeedViewModel
import com.vigelos.piontest.viewmodel.adapter.NewFeedAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewFeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView
        lifecycleScope.launch {
            viewModel.fetchNewFeedJson()
        }
        viewModel.newFeedJson.observe(viewLifecycleOwner) { newFeedJson ->
            val items = newFeedJson.items.filter { it.contentType == "gallery" }
            val adapter = NewFeedAdapter(items)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}