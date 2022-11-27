package com.rentreadychecklist.model.miscellaneous

import com.rentreadychecklist.model.livingRoom.LivingRoomFix
import com.rentreadychecklist.model.livingRoom.LivingRoomItemList

data class Miscellaneous (

    val items: MiscellaneousItemList,
    var ok:String,
    var na:String,
    var fix: MiscellaneousFix

)