package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.androidhomeworks.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var viewBinding: FragmentThirdBinding
    private lateinit var navController: NavController
    private lateinit var adapter: DynamicPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Задача 1: ViewPager2 с динамическими фрагментами
        setupViewPager()
        navController = findNavController()

        setupButtonClickListener(viewBinding.button, ::showInputDialog)
        setupButtonClickListener(viewBinding.button2, ::navigateToFourthFragment)
    }

    private fun setupViewPager() {
        withBinding {
            adapter = DynamicPagerAdapter(this@ThirdFragment)
            viewPager.adapter = adapter

            adapter.addFragment(FirstFragment())
            adapter.addFragment(SecondFragment())
        }
    }

    private fun withBinding(block: FragmentThirdBinding.() -> Unit) {
        viewBinding.let {
            block.invoke(it)
        }
    }

    private fun showInputDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Введите текст для нового фрагмента")

        val input = EditText(requireContext())
        builder.setView(input)

        builder.setPositiveButton("Добавить") { _, _ ->
            val text = input.text.toString()
            addNewFragment(text)
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun addNewFragment(text: String) {
        val newFragment = DynamicFragment.getInstance(text)
        adapter.addFragment(newFragment)
    }

    private fun setupButtonClickListener(button: Button, action: () -> Unit) {
        button.setOnClickListener {
            action()
        }
    }

    private fun navigateToFourthFragment() {
        navController.navigate(R.id.action_thirdFragment_to_fourthFragment)
    }
}