package com.rentreadychecklist.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.rentreadychecklist.R
import com.rentreadychecklist.constants.Constants.Companion.FORMID
import com.rentreadychecklist.databinding.FragmentNewChecklistBinding
import com.rentreadychecklist.formDataSave.FormsDummyData
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.outside.OutSideFix
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.model.outside.OutsideItemList
import com.rentreadychecklist.viewmodel.AppViewModel
import java.text.SimpleDateFormat
import java.util.*

class NewChecklistFragment : Fragment() {
   lateinit var viewBinding: FragmentNewChecklistBinding
    private lateinit var viewModel: AppViewModel

    private lateinit var  formsDummyData:FormsDummyData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentNewChecklistBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        formsDummyData= FormsDummyData()
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCurrentDateTime()
        viewBinding.next.setOnClickListener{
            setDataToViewModel()
            view.findNavController().navigate(R.id.action_newChecklistFragment2_to_outsideFormFragment)

        }

    }

    private fun getCurrentDateTime()
    {
        val currentDateYear = SimpleDateFormat("dd/MMM/yyyy",Locale.getDefault())
        val currentDate = currentDateYear.format(Date())
        val currentTime = SimpleDateFormat("h:mm a", Locale.getDefault()).format(
            Date())
        viewBinding.time.setText(currentTime)
        viewBinding.date.setText(currentDate)
    }

    private fun setDataToViewModel() {

        val currentDate= viewBinding.date.text
        val currentTime = viewBinding.time.text
        val propertyAddress=viewBinding.propertyAddress.text
        Log.d("address",propertyAddress.toString())
        val homeScreenData:MutableList<HomeScreen> = mutableListOf()
        homeScreenData.add(HomeScreen(currentDate.toString(),currentTime.toString(),propertyAddress.toString(),""))
        viewModel.updateHomeScreen(homeScreenData,FORMID)
    }




}