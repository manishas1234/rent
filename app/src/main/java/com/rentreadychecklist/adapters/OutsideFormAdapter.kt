package com.rentreadychecklist.adapters

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.rentreadychecklist.R
import com.rentreadychecklist.db.AppData
import com.rentreadychecklist.model.outside.OutSideFix
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.model.outside.OutsideItemList
import com.rentreadychecklist.viewmodel.AppViewModel


class OutsideFormAdapter(private val context: Context, private val outdoorItemList: ArrayList<String>, private val registry: ActivityResultLauncher<Intent>, private val outsideItemList: MutableList<Outside>, lifeCycleStoreOwner: ViewModelStoreOwner,
                         private val lifeCycleOwner: LifecycleOwner
):RecyclerView.Adapter<OutsideFormAdapter.ViewHolder>() {

    val viewModel = ViewModelProvider(lifeCycleStoreOwner)[AppViewModel::class.java]

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var formItemText : TextView
        var needFixLinearLayout: LinearLayout
        var dishCableStoryLinearLayout: LinearLayout
        var timeTextInputlayout: TextInputLayout
        var radioGroup: RadioGroup
        var okButton : RadioButton
        var naButton : RadioButton
        var fixButton : RadioButton
        var timeInHourMinute : EditText
        var uploadImageLayout : LinearLayout
        var image : ImageView
        var product: EditText
        var notes: EditText
        var saveFix:Button

        init {
            formItemText = view.findViewById(R.id.formItemText)
            needFixLinearLayout = view.findViewById(R.id.needFixLinearLayout)
            dishCableStoryLinearLayout = view.findViewById(R.id.dishCableStoryLinearLayout)
            radioGroup = view.findViewById(R.id.okNaFixRadioGroup)
            okButton = view.findViewById(R.id.ok)
            naButton = view.findViewById(R.id.na)
            fixButton = view.findViewById(R.id.fix)
            timeInHourMinute = view.findViewById(R.id.timeInHourMinute)
            timeTextInputlayout = view.findViewById(R.id.timeTextInputLayout)
            uploadImageLayout = view.findViewById(R.id.uploadImageLayout)
            image = view.findViewById(R.id.image)
            product = view.findViewById(R.id.product)
            notes = view.findViewById(R.id.notes)
            saveFix=view.findViewById(R.id.saveFix)

            val anim = AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_slide_in_bottom)
            anim.duration = 2000
            view.startAnimation(anim)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.outside_form_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.formItemText.text = outdoorItemList[position]

        Log.d("outsidead", holder.adapterPosition.toString()

        )
            if (holder.adapterPosition==8){
                holder.dishCableStoryLinearLayout.visibility = View.VISIBLE
            }

        holder.okButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.GONE
            Log.d("checkList", outsideItemList.toString())
            outsideItemList[holder.adapterPosition].ok="ok"
            outsideItemList[holder.adapterPosition].na=""
            outsideItemList[holder.adapterPosition].fix = OutSideFix("","","","","")
        }

        holder.naButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.GONE
            outsideItemList[holder.adapterPosition].ok=""
            outsideItemList[holder.adapterPosition].na="na"
            outsideItemList[holder.adapterPosition].fix = OutSideFix("","","","","")

        }




        holder.fixButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.VISIBLE
        }

        holder.saveFix.setOnClickListener {

            outsideItemList[holder.adapterPosition].ok=""
            outsideItemList[holder.adapterPosition].na=""
            outsideItemList[holder.adapterPosition].fix.fix= "Fix"
            outsideItemList[holder.adapterPosition].fix.time=holder.timeInHourMinute.text.toString()
            outsideItemList[holder.adapterPosition].fix.product=holder.product.text.toString()
            outsideItemList[holder.adapterPosition].fix.notes = holder.notes.text.toString()

        }





        holder.uploadImageLayout.setOnClickListener(){
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            intent.type = "image/*"
            registry.launch(intent)

        }

    }

    override fun getItemCount(): Int {
        return outdoorItemList.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // do you stuff

    }

}