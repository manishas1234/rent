package com.rentreadychecklist.model.frontdoors

import com.rentreadychecklist.model.outside.OutSideFix

data class FrontDoors(
    val items:String,
    val ok:String,
    val NA:String,
    val fix: FrontDoorFix
)