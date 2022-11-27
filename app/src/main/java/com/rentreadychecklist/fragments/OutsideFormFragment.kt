package com.rentreadychecklist.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentreadychecklist.adapters.OutsideFormAdapter
import com.rentreadychecklist.constants.Constants.Companion.FORMID
import com.rentreadychecklist.databinding.FragmentOutsideFormBinding
import com.rentreadychecklist.formDataSave.FormsDummyData
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.pdf.PdfGenerator
import com.rentreadychecklist.viewmodel.AppViewModel
import java.io.InputStream


class OutsideFormFragment : Fragment() {

    private val items = arrayListOf("Fence :","Gate :", "Porch/Coach Light:", "Anti- Siphon breaker valve and Insulation",
        "Power Washing Driveway :","Weather proof receptacle ncover at front door :","Stucco :","Shutters :",
         "Satellite dish and cables :","Address Numbers or Letters :")

    lateinit var outSideItemList: MutableList<Outside>
    lateinit var formsDummyData:FormsDummyData
    lateinit var viewBinding: FragmentOutsideFormBinding
    lateinit var adapter: OutsideFormAdapter
    lateinit var viewModel:AppViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentOutsideFormBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        formsDummyData = FormsDummyData()
        formsDummyData.outsideDataAdd()
        outSideItemList = mutableListOf()


        val linearLayout = LinearLayoutManager(context)
        viewBinding.recyclerView.layoutManager = linearLayout
        outSideItemList= formsDummyData.outsideData
        adapter = OutsideFormAdapter(requireContext(), items,startForResult, outSideItemList,this,this)
        viewBinding.recyclerView.setItemViewCacheSize(items.size)
        viewBinding.recyclerView.adapter = adapter

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.previous.setOnClickListener(){
            Log.d("checkOutsideList", outSideItemList.toString())

        }
        viewBinding.next.setOnClickListener {

            viewModel.updateOutside(outSideItemList,FORMID)


            viewModel.readFormDataID.observe(viewLifecycleOwner,Observer{
                Log.d("dataview",it.toString())
                val pdfGenerator = PdfGenerator(requireContext())
               pdfGenerator.pdfGenerator(it)


            })


        }

        viewModelObserver()
        Log.d("listcheck", outSideItemList.toString())


    }

     fun viewModelObserver(){
         viewModel.readFormData.observe(viewLifecycleOwner, Observer { data->
             Log.d("getdata", data.toString())

         })
     }


    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data

            Log.d("intentImage", intent?.data?.path.toString())
            val inputStream: InputStream? =
                intent?.data?.let { context?.contentResolver?.openInputStream(it) }

          /*  val title = "Rent Ready"
            val path = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),title)
            val f =File(path.path, intent.toString())
            f.createNewFile()  */

            // Handle the Intent
            //do stuff here
        }
    }

}