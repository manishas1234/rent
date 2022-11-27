package com.rentreadychecklist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.R
import com.rentreadychecklist.adapters.LivingRoomAdapter
import com.rentreadychecklist.adapters.MiscellaneousAdapter
import com.rentreadychecklist.databinding.FragmentMiscellaneousFromBinding

class MiscellaneousFromFragment : Fragment() {

    private val items = arrayListOf(
        "Cleaning",
        "Tennent Personal Belongings :",
        "Furniture :",
        "Hire Outside Company For Deep Cleaning :",
        "Smoke Detectors (One In Each Bedroom, Hall, And Living Room)",
        "Batteries In Smoke Detectors: Count",
        "Smoke Detectors Replace Because They Don’t Work Or Are Missing: Count :",
        "C/O In Each Hall :",
        "A/C (Requires Professional Diagnoses) :",
        "A/C Vents: Replace :",
        "A/C Filters: Replace :",
        "A/C Filters Cover, Caps, Screws :",
        "Foam Around Compressor :",
        "Stairs/ Hallway :",
        "Outlets :",
        "Covers :",
        "Service Covers :",
        "Lights :",
        "Light Bulbs Needed :",
        "Floor Covering :",
        "Hand Rails :",
        "Walls :",
        "Blinds :",
    )

     lateinit var viewBinding: FragmentMiscellaneousFromBinding
    lateinit var adapter: MiscellaneousAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentMiscellaneousFromBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = MiscellaneousAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }

}