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

class MiscellaneousAdapter(private val context: Context, private val item:ArrayList<String>):RecyclerView.Adapter<MiscellaneousAdapter.ViewHolder>() {

    val itemContain= arrayListOf("Carpet And Flooring","Carpet And Flooring","Windows","Electrical", "Closet","Fireplace")

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
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

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.outside_form_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.formItemText.text = item[position]

        if (itemContain.contains(item[position])){
            holder.radioGroup.visibility = View.GONE
            holder.formItemText.setTypeface(Typeface.DEFAULT_BOLD)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

}