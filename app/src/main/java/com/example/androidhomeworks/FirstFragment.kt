package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.androidhomeworks.SecondFragment.Companion.RESULT_KEY
import com.example.androidhomeworks.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var navController: NavController

    private lateinit var viewBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupOnClickListener()
        getResultFromSecondFragment(RESULT_KEY)

    }

    private fun setupOnClickListener() {
        viewBinding.button.setOnClickListener {
            navigateToSecondFragment(getStringFromEditText())
        }
    }

    private fun getResultFromSecondFragment(key: String) {
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>(key)?.observe(
            viewLifecycleOwner
        ) { result ->
            viewBinding.textView.text = result
        }
    }

    private fun navigateToSecondFragment(text: String) {
        navController.navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(text))
    }

    private fun getStringFromEditText(): String {
        return viewBinding.editText.text.toString()
    }

}