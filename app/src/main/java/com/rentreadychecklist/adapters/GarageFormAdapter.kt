package com.rentreadychecklist.adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.rentreadychecklist.R


class GarageFormAdapter(private val context: Context, private val garageItemList: ArrayList<String>): RecyclerView.Adapter<GarageFormAdapter.ViewHolder>() {

    val itemContain= arrayListOf("Electrical", "Water Heater")

    inner class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        var formItemText : TextView

        var needFixLinearLayout: LinearLayout
        var timeTextInputlayout: TextInputLayout
        var radioGroup: RadioGroup
        var okButton : RadioButton
        var naButton : RadioButton
        var fixButton : RadioButton
        var timeInHourMinute : EditText
        var uploadImageLayout : LinearLayout
        var image : ImageView

        init {
            formItemText = view.findViewById(R.id.formItemText)
            needFixLinearLayout = view.findViewById(R.id.needFixLinearLayout)
            radioGroup = view.findViewById(R.id.okNaFixRadioGroup)
            okButton = view.findViewById(R.id.ok)
            naButton = view.findViewById(R.id.na)
            fixButton = view.findViewById(R.id.fix)
            timeInHourMinute = view.findViewById(R.id.timeInHourMinute)
            timeTextInputlayout = view.findViewById(R.id.timeTextInputLayout)
            uploadImageLayout = view.findViewById(R.id.uploadImageLayout)
            image = view.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.outside_form_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.formItemText.text = garageItemList[position]


        if (itemContain.contains(garageItemList[position])){
            holder.radioGroup.visibility = View.GONE
            holder.formItemText.setTypeface(Typeface.DEFAULT_BOLD)
        }

        holder.fixButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.VISIBLE
        }

        holder.okButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.GONE
        }

        holder.naButton.setOnClickListener{
            holder.needFixLinearLayout.visibility = View.GONE

        }
    }

    override fun getItemCount(): Int {
        return garageItemList.size
    }


}