package com.rentreadychecklist.model.laundry

import com.rentreadychecklist.model.outside.OutSideFix

data class LaundryRoom (

    val items:String,
    var ok:String,
    var na:String,
    var fix: LaundryRoomFix

)