package com.rentreadychecklist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.adapters.FrontDoorFormAdapter
import com.rentreadychecklist.databinding.FragmentKitchenFormBinding


class KitchenFormFragment : Fragment() {

    private val items = arrayListOf(
        "Grout And Caulk In Kitchen :",
        "Cabinet Doors And Handles :",
        "Shelves :",
        "Cabinet Drawers :",
        "Filter In Vent Hood :",
        "Hood Light And Fan :",
        "Vent Covers :",
        "Island :",
        "Electrical :",
        "Lights :",
        "Light Bulbs Needed :",
        "Ceiling Fans :",
        "Outlets :",
        "Covers :",
        "Service Covers :",
        "Sink :",
        "Faucets :",
        "Garbage Disposal :",
        "Air Gap Cap :",
        "Guard :",
        "Under Sinks Leak :",
        "Damage Under Sink :",
        "Appliances (Check For Filters, Knobs, Racks, Shelves, Drip Pans, Light Bulbs) Take Condition Photos And Modal Number For All Appliances :",
        "Refrigerator :",
        "Oven :",
        "Dishwasher :",
        "Microwave :",
        "Pantry :",
        "Pantry Door Guide/Track, Handles :",
        "Pantry Door Open And Close :",
        "Racks, Rods, Shelves :",

    )

    lateinit var adapter: FrontDoorFormAdapter

  lateinit var viewBinding: FragmentKitchenFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding =  FragmentKitchenFormBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = FrontDoorFormAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }

}