package com.rentreadychecklist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.R
import com.rentreadychecklist.adapters.FrontDoorFormAdapter
import com.rentreadychecklist.adapters.GarageFormAdapter
import com.rentreadychecklist.databinding.FragmentFrontDoorsFormBinding
import com.rentreadychecklist.databinding.FragmentGarageFormBinding

class GarageFormFragment : Fragment() {

    private val items = arrayListOf("Garage Door Works :","Garage Door Opener :", "Garage Door To House Self-Closing Hinges :", "Locks/ Knobs :",
        "Cabinets :","Electrical","Lights :","Light Bulbs Needed :",
        "Ceiling Fans :","Outlets :", "Covers :","Service covers :","Lighting :","Power Wash Floor :","Water Softener Removal: :","Water Heater"
    ,"Hot Water Heater Earthquake Straps :","Hot Water Heater Collection Pan With Hose Leading To Outside Overflow :","Drain To Outside :","TPRV Flows Down :")


    lateinit var adapter: GarageFormAdapter
    private lateinit var viewBinding: FragmentGarageFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding =  FragmentGarageFormBinding.inflate(inflater, container, false)

        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        adapter = GarageFormAdapter(requireContext(), items)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }



}