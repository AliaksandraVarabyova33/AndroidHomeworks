package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.androidhomeworks.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var viewBinding: FragmentSecondBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupButtonClickListener(viewBinding.button, ::navigateToThirdFragment)

    }

    private fun setupButtonClickListener(button: Button, action: () -> Unit) {
        button.setOnClickListener {
            action()
        }
    }

    private fun navigateToThirdFragment() {
        navController.navigate(R.id.action_secondFragment_to_thirdFragment)
    }
}