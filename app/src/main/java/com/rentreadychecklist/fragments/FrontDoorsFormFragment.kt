package com.rentreadychecklist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.adapters.FrontDoorFormAdapter
import com.rentreadychecklist.databinding.FragmentFrontDoorsFormBinding

class FrontDoorsFormFragment : Fragment() {

    private val items = arrayListOf("Doors :","Astragal :", "Door Bell :", "Door Locks: ",
        "Door Knobs :","Sagging Hinges :","Strike Plates :","Missing Hardware On Doors :",
        "Peep Hole (Height 60” From The Bottom Of Door) :","Door Stops :", "Weather Stripping :")

    lateinit var viewBinding: FragmentFrontDoorsFormBinding
    lateinit var adapter: FrontDoorFormAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentFrontDoorsFormBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = FrontDoorFormAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }

}