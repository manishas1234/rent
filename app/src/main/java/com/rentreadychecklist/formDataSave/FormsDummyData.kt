package com.rentreadychecklist.formDataSave

import com.rentreadychecklist.model.bathroom.Bathroom
import com.rentreadychecklist.model.bathroom.BathroomFix
import com.rentreadychecklist.model.bathroom.BathroomItemList
import com.rentreadychecklist.model.bathroom.Bathrooms
import com.rentreadychecklist.model.bedrooms.Bedroom
import com.rentreadychecklist.model.bedrooms.BedroomFix
import com.rentreadychecklist.model.bedrooms.BedroomItemList
import com.rentreadychecklist.model.bedrooms.Bedrooms
import com.rentreadychecklist.model.diningRoom.DiningRoom
import com.rentreadychecklist.model.diningRoom.DiningRoomFix
import com.rentreadychecklist.model.diningRoom.DiningRoomItemList
import com.rentreadychecklist.model.frontdoors.FrontDoorFix
import com.rentreadychecklist.model.frontdoors.FrontDoors
import com.rentreadychecklist.model.garage.Garage
import com.rentreadychecklist.model.garage.GarageFix
import com.rentreadychecklist.model.greatroom.GreatRoom
import com.rentreadychecklist.model.greatroom.GreatRoomFix
import com.rentreadychecklist.model.greatroom.GreatRoomItemList
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.kitchen.Kitchen
import com.rentreadychecklist.model.kitchen.KitchenFix
import com.rentreadychecklist.model.kitchen.KitchenItemList
import com.rentreadychecklist.model.laundry.LaundryRoom
import com.rentreadychecklist.model.laundry.LaundryRoomFix
import com.rentreadychecklist.model.livingRoom.LivingRoomItemList
import com.rentreadychecklist.model.livingRoom.LivingRoom
import com.rentreadychecklist.model.livingRoom.LivingRoomFix
import com.rentreadychecklist.model.miscellaneous.Miscellaneous
import com.rentreadychecklist.model.miscellaneous.MiscellaneousFix
import com.rentreadychecklist.model.miscellaneous.MiscellaneousItemList
import com.rentreadychecklist.model.outside.OutSideFix
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.model.outside.OutsideItemList

class FormsDummyData {

     var homeScreenData:MutableList<HomeScreen> = mutableListOf()
     var outsideData:MutableList<Outside> = mutableListOf()
     var frontDoorsData:MutableList<FrontDoors> = mutableListOf()
     var garageData:MutableList<Garage> = mutableListOf()
     var laundryRoomData:MutableList<LaundryRoom> = mutableListOf()
     var livingRoomData:MutableList<LivingRoom> = mutableListOf()
     var greatRoomData:MutableList<GreatRoom> = mutableListOf()
     var diningRoomData:MutableList<DiningRoom> = mutableListOf()
     var kitchenData:MutableList<Kitchen> = mutableListOf()
     var miscellaneousData:MutableList<Miscellaneous> = mutableListOf()
     var bedroom:MutableList<Bedroom> = mutableListOf()
     var bathroom:MutableList<Bathroom> = mutableListOf()

    fun  homeScreenDataAdd()
    {
        homeScreenData.add(HomeScreen("","","",""))
    }

    fun  outsideDataAdd()
    {
        outsideData.add(Outside(OutsideItemList("Fence:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Gate:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Porch/Coach Light:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Anti-Siphon breaker value and Insulation:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Power Washing Driveway:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Weatherproof Receptacle Cover At Front Door:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Stucco:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Shutters:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Satellite Dish And Cables:",false,false),"","", OutSideFix("","","","","")))
        outsideData.add(Outside(OutsideItemList("Address Numbers Or Letters:",false,false),"","", OutSideFix("","","","","")))

    }

    fun frontDoorsDataAdd()
    {
        frontDoorsData.add(FrontDoors("","","", FrontDoorFix("","","","","")))

    }

    fun  garageDataAdd()
    {
        garageData.add(Garage("","","", GarageFix("","","","","")))

    }

    fun laundryRoomAdd()
    {
        laundryRoomData.add(LaundryRoom("","","", LaundryRoomFix("","","","","")))

    }

    fun livingRoomAdd()
    {
        livingRoomData.add(LivingRoom(LivingRoomItemList("",false,false,"","",""),"","", LivingRoomFix("","","","","")))
    }

    fun greatRoomAdd()
    {
        greatRoomData.add(GreatRoom(GreatRoomItemList("",false,false,"","",""),"","",
            GreatRoomFix("","","","","")))
    }

    fun diningRoomAdd()
    {
        diningRoomData.add(DiningRoom(DiningRoomItemList("",false,false,"","",""),"","",DiningRoomFix("","","","","")))
    }

    fun kitchenAdd()
    {
        kitchenData.add(Kitchen(KitchenItemList("",false,false),"","",KitchenFix("","","","","")))
    }

    fun miscellaneousAdd()
    {
        miscellaneousData.add(Miscellaneous(MiscellaneousItemList("",false,false),"","",
            MiscellaneousFix("","","","","")))
    }

    fun bedroomAdd()
    {
        bedroom.add(Bedroom(Bedrooms(BedroomItemList("",false,false,"","",""),"",
        "",BedroomFix("","","","",""))))

    }

    fun bathroomAdd()
    {
        bathroom.add(Bathroom(Bathrooms(BathroomItemList("",false,false,"",
        "",""),"","", BathroomFix("","","","",""))))
    }










}