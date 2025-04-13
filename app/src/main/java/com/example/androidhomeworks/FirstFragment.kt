package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.androidhomeworks.databinding.FragmentFirstBinding
import com.example.androidhomeworks.databinding.FragmentThirdBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator


class FirstFragment : Fragment() {

    private lateinit var viewBinding: FragmentFirstBinding
    private lateinit var navController: NavController

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

        setupButtonClickListener(viewBinding.button, ::navigateToSecondFragment)

        //Задача 1: ViewBinding: безопасный доступ к View + Задача 2*: Snackbar с действием
        setupButtonClickListener(viewBinding.buttonChange, ::changeTextWithSnackbar)
    }

    private fun setupButtonClickListener(button: Button, action: () -> Unit) {
        button.setOnClickListener {
            action()
        }
    }

    private fun navigateToSecondFragment() {
        navController.navigate(R.id.action_firstFragment_to_secondFragment)
    }

    private fun changeTextWithSnackbar() {
        var isCancelled = false
        val snackbar = Snackbar.make(
            viewBinding.firstFragmentLayout,
            "Are you sure you want to change text?",
            Snackbar.LENGTH_SHORT
        )

        snackbar.setAction("UNDO") {
            isCancelled = true
        }

        snackbar.show()

        snackbar.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                if (!isCancelled) {
                    viewBinding.textView.text = getString(R.string.changed_text)
                }
            }
        })
    }
}