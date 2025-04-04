package com.vigelos.piontest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.vigelos.piontest.R
import com.vigelos.piontest.databinding.FragmentHomeBinding
import com.vigelos.piontest.viewmodel.adapter.ViewPagerAdapter

class HomeFragment : Fragment() {

    private var _bindind: FragmentHomeBinding? = null
    private val binding get() = _bindind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _bindind = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        val tabTitles = listOf("Story", "Gallery", "Video", "Article", "Long Form")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}