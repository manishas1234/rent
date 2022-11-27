package com.rentreadychecklist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.R
import com.rentreadychecklist.adapters.FrontDoorFormAdapter
import com.rentreadychecklist.databinding.FragmentHomeBinding
import com.rentreadychecklist.databinding.FragmentLaundryRoomFormBinding

class LaundryRoomFormFragment : Fragment() {

    private val items = arrayListOf(
        "Clothes Washer :",
        "Washer Shut Off Valves :",
        "Hose And Supply Line :",
        "Hose And Supply Line :",
        "Lint Screen :",
        "Lint Path :",
        "Walls/ Damage :",
        "Doors :",
        "Door Locks/Knobs :",
        "Door Stops :",
        "Missing Hardware On Doors :",
        "Lights :",
        "Light Bulbs Needed :",
        "Vent Fans :",
        "Outlets :",
        "Covers :",
        "Service Covers :",
        "Cabinet Doors and Handles :",
        "Cabinet Drawers :",
        "Shelves :",

    )

    lateinit var viewBinding: FragmentLaundryRoomFormBinding
    lateinit var adapter: FrontDoorFormAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentLaundryRoomFormBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = FrontDoorFormAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }

}