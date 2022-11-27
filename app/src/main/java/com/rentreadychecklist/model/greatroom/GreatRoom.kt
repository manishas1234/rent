package com.rentreadychecklist.model.greatroom

import com.rentreadychecklist.model.livingRoom.LivingRoomFix
import com.rentreadychecklist.model.livingRoom.LivingRoomItemList

data class GreatRoom (
        val items: GreatRoomItemList,
        var ok:String,
        var na:String,
        var fix: GreatRoomFix


)