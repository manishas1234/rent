package com.rentreadychecklist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.R
import com.rentreadychecklist.adapters.FrontDoorFormAdapter
import com.rentreadychecklist.adapters.LivingRoomAdapter
import com.rentreadychecklist.databinding.FragmentLaundryRoomFormBinding
import com.rentreadychecklist.databinding.FragmentLivingRoomFormBinding

class LivingRoomFormFragment : Fragment() {

    private val items = arrayListOf(
        "Vent Covers :",
        "Carpet And Flooring",
        "Carpet :",
        "Loose Or Cracked Tiles Or Damaged Floor :",
        "Walls/ Baseboards/ Ceiling",
        "Paint :",
        "Drywall Damage :",
        "Remove / Repair Nails, Hangers, Etc :",
        "Evidence Of Water Damage :",
        "Windows",
        "Open And Close Easily :",
        "Screens (Each Window And Sliding Glass Door) :",
        "Locking Device :",
        "Broken, Cracked Or Missing :",
        "Blinds :",
        "Condensation Between Window Panes :",
        "Electrical",
        "Lights :",
        "Light Bulbs Needed :",
        "Outlets :",
        "Covers :",
        "Service Covers :",
        "Closets",
        "Closet Door Guide/Track, Handles :",
        "Closet Door Open And Close :",
        "Racks, Rods, Shelves :",
        "Fireplace",
        "Missing Key :"

        )

    lateinit var adapter: LivingRoomAdapter

    lateinit var viewBinding: FragmentLivingRoomFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentLivingRoomFormBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = LivingRoomAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }




}