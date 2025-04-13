package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.androidhomeworks.databinding.FragmentFirstBinding
import com.example.androidhomeworks.databinding.FragmentFourthBinding
import com.google.android.material.tabs.TabLayoutMediator


class FourthFragment : Fragment() {

    private lateinit var viewBinding: FragmentFourthBinding
    private lateinit var adapter: DynamicPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFourthBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Задача 2: ViewPager2 с Tabs + Задача 3: Иконка и текст в TabLayout
        setupViewPager()
    }

    private fun setupViewPager() {
        withBinding {
            adapter = DynamicPagerAdapter(this@FourthFragment)
            viewPager.adapter = adapter

            adapter.addFragment(DynamicFragment.getInstance("Fragment 1"))
            adapter.addFragment(DynamicFragment.getInstance("Fragment 2"))
            adapter.addFragment(DynamicFragment.getInstance("Fragment 3"))

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = "Tab ${position + 1}"
            }.attach()
        }
    }

    private fun withBinding(block: FragmentFourthBinding.() -> Unit) {
        viewBinding.let {
            block.invoke(it)
        }
    }

}