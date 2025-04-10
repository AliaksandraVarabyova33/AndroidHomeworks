package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidhomeworks.databinding.FragmentFirstBinding
import com.example.androidhomeworks.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var navController: NavController

    private lateinit var viewBinding: FragmentSecondBinding

    private val arguments: SecondFragmentArgs by navArgs()

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
        setupOnClickListener(viewBinding.button, ::navigateToThirdFragment)
        setTextViewTextFromArguments()
        setupOnClickListener(viewBinding.button2, ::returnResultToFirstFragment)

    }

    private fun setupOnClickListener(button: Button, operation: () -> Unit) {
        button.setOnClickListener {
            operation()
        }
    }

    private fun returnResultToFirstFragment() {
        val result = getStringFromEditText()
        navController.previousBackStackEntry?.savedStateHandle?.set(RESULT_KEY, result)
        navController.popBackStack()
    }

    private fun navigateToThirdFragment() {
        navController.navigate(R.id.action_secondFragment_to_thirdFragment)
    }

    private fun setTextViewTextFromArguments() {
        viewBinding.textView.text = arguments.text
    }

    private fun getStringFromEditText(): String {
        return viewBinding.editText.text.toString()
    }

    companion object {
        const val RESULT_KEY = "RESULT"
    }
}