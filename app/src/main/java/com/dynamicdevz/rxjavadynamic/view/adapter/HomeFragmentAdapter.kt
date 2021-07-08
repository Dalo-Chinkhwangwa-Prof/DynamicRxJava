package com.dynamicdevz.rxjavadynamic.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dynamicdevz.rxjavadynamic.view.fragment.GridFragment
import com.dynamicdevz.rxjavadynamic.view.fragment.ListFragment

class HomeFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> ListFragment()
            else -> GridFragment()
        }
    }
}