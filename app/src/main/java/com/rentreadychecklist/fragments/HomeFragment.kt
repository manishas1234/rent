package com.rentreadychecklist.fragments


import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.rentreadychecklist.R
import com.rentreadychecklist.constants.Constants.Companion.FORMID
import com.rentreadychecklist.databinding.FragmentHomeBinding
import com.rentreadychecklist.db.AppData
import com.rentreadychecklist.formDataSave.FormsDummyData
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.viewmodel.AppViewModel
import java.io.File


class HomeFragment : Fragment() {
    private lateinit var formsDummyData:FormsDummyData
    lateinit var viewBinding: FragmentHomeBinding
    private lateinit var viewModel:AppViewModel
    private lateinit var outsideItemList:MutableList<Outside>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =  FragmentHomeBinding.inflate(inflater, container, false)
        formsDummyData= FormsDummyData()
        outsideItemList = mutableListOf()
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       requestPermission()    //permission for read and write



        makeFolder()


        viewBinding.newChecklist.setOnClickListener(){
            formsDummyData.homeScreenDataAdd()
            formsDummyData.outsideDataAdd()
            formsDummyData.frontDoorsDataAdd()
            formsDummyData.garageDataAdd()
            formsDummyData.laundryRoomAdd()
            formsDummyData.livingRoomAdd()
            formsDummyData.greatRoomAdd()
            formsDummyData.diningRoomAdd()
            formsDummyData.kitchenAdd()
            formsDummyData.miscellaneousAdd()
            formsDummyData.bedroomAdd()
            formsDummyData.bathroomAdd()
            val addForm=AppData(0,formsDummyData.homeScreenData,formsDummyData.outsideData,formsDummyData.frontDoorsData,
            formsDummyData.garageData,formsDummyData.laundryRoomData,formsDummyData.livingRoomData,
            formsDummyData.greatRoomData,formsDummyData.diningRoomData,formsDummyData.kitchenData,
            formsDummyData.miscellaneousData,formsDummyData.bedroom,formsDummyData.bathroom)
            viewModel.insertFormInfo(addForm)


                Log.d("idnew",FORMID.toString())
            view.findNavController().navigate(R.id.navigationDrawerFragment)
            //view.findNavController().navigate(R.id.action_homeFragment_to_newChecklistFragment)

        }

        viewBinding.savedChecklist.setOnClickListener(){
            view.findNavController().navigate(R.id.action_homeFragment_to_savedChecklistFragment)
        }

        viewBinding.insurance.setOnClickListener(){

        }

        viewBinding.other.setOnClickListener(){

        }
    }

    private fun requestPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireContext() as Activity,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                101
            )
        }

        ActivityCompat.requestPermissions(
            requireContext() as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            101
        )
    }

    fun makeFolder(){
        val title = "Rent Ready"
        val path = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),title)

        if (!path.exists()){
            path.mkdir()
            Log.d("pathecreated", path.path)
        }

    }

}