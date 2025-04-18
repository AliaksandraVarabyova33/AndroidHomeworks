package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.androidhomeworks.databinding.FragmentFirstBinding
import com.example.androidhomeworks.databinding.FragmentFourthBinding


class FourthFragment : Fragment() {

    private lateinit var viewBinding: FragmentFourthBinding
    private lateinit var adapter: NameRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFourthBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<String>()


        adapter = NameRecyclerViewAdapter(list)
        viewBinding.recyclerView.adapter = adapter
        viewBinding.recyclerView.visibility = GONE

        viewBinding.buttonEmpty.setOnClickListener {
            adapter.setData(emptyList())
            updateUI(true)
        }

        viewBinding.buttonNotEmpty.setOnClickListener {
            val newList = List(30) { "Name $it" }
            adapter.setData(newList)
            updateUI(false)
        }
    }

    private fun updateUI(isListEmpty: Boolean) {
        if (isListEmpty) {
            viewBinding.recyclerView.visibility = GONE
            viewBinding.textView.visibility = VISIBLE
        } else {
            viewBinding.recyclerView.visibility = VISIBLE
            viewBinding.textView.visibility = GONE
        }
    }
}