package com.rentreadychecklist.model.garage

import com.rentreadychecklist.model.outside.OutSideFix

data class Garage(

    val items:String,
    var ok:String,
    var na:String,
    var fix: GarageFix

)