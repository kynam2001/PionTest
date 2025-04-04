package com.vigelos.piontest.viewmodel.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vigelos.piontest.ui.ArticleFragment
import com.vigelos.piontest.ui.GalleryFragment
import com.vigelos.piontest.ui.LongFormFragment
import com.vigelos.piontest.ui.StoryFragment
import com.vigelos.piontest.ui.VideoFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> StoryFragment()
            1 -> GalleryFragment()
            2 -> VideoFragment()
            3 -> ArticleFragment()
            4 -> LongFormFragment()
            else -> StoryFragment()
        }
    }
}