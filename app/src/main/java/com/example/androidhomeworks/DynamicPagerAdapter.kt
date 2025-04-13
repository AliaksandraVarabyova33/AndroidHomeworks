package com.example.androidhomeworks

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DynamicPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentsList = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }

    fun addFragment(fragment: Fragment) {
        fragmentsList.add(fragment)
        notifyItemInserted(fragmentsList.size - 1)
    }
}