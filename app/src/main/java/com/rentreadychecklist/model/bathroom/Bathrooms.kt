package com.rentreadychecklist.model.bathroom

import com.rentreadychecklist.model.bedrooms.BedroomFix
import com.rentreadychecklist.model.bedrooms.BedroomItemList

data class Bathrooms (

    val items: BathroomItemList,
    var ok:String,
    var na:String,
    var fix: BathroomFix
        )