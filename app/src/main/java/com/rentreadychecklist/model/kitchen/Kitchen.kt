package com.rentreadychecklist.model.kitchen

import com.rentreadychecklist.model.livingRoom.LivingRoomFix
import com.rentreadychecklist.model.livingRoom.LivingRoomItemList

data class Kitchen (
    val items: KitchenItemList,
    var ok:String,
    var na:String,
    var fix: KitchenFix

)