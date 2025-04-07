package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidhomeworks.MainActivity.Companion.ACTIVITY_STRING_KEY


class MyFragment : Fragment() {

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.frTextView)
        textView.text = arguments?.getString(ACTIVITY_STRING_KEY) ?: String.empty

    }

    companion object {

        fun getInstance(text: String): MyFragment {
            return MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ACTIVITY_STRING_KEY, text)
                }
            }
        }
    }
}