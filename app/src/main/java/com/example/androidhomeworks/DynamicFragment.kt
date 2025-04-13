package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidhomeworks.databinding.FragmentDynamicBinding


class DynamicFragment : Fragment() {

    private lateinit var textView: TextView
    private var userInput: String? = null
    private lateinit var viewBinding: FragmentDynamicBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDynamicBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = viewBinding.textView
        userInput = arguments?.getString(USER_INPUT_KEY) ?: DEFAULT_TEXT
        textView.text = userInput
    }

    companion object {
        const val USER_INPUT_KEY = "USER_INPUT"
        const val DEFAULT_TEXT = "Default Text"

        fun getInstance(text: String): DynamicFragment {
            val fragment = DynamicFragment()
            val args = Bundle()
            args.putString(USER_INPUT_KEY, text)
            fragment.arguments = args
            return fragment
        }

    }
}