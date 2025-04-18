package com.example.androidhomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.androidhomeworks.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var viewBinding: FragmentThirdBinding
    private lateinit var navController: NavController
    private lateinit var adapter: NameRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<String>()
        adapter = NameRecyclerViewAdapter(list)
        viewBinding.recyclerView.adapter = adapter
        viewBinding.button.setOnClickListener {
            addNameToList(list)
        }
    }

    private fun addNameToList(list: ArrayList<String>) {
        val name = viewBinding.editText.text.toString()
        if (name.isNotEmpty()) {
            adapter.addItem(name)
            viewBinding.editText.text.clear()
        }
    }
}