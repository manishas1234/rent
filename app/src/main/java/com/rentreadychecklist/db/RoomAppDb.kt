package com.rentreadychecklist.db

import android.content.Context
import androidx.room.*
import com.google.gson.Gson
import com.rentreadychecklist.model.bathroom.Bathroom
import com.rentreadychecklist.model.bedrooms.Bedroom
import com.rentreadychecklist.model.diningRoom.DiningRoom
import com.rentreadychecklist.model.frontdoors.FrontDoors
import com.rentreadychecklist.model.garage.Garage
import com.rentreadychecklist.model.greatroom.GreatRoom
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.kitchen.Kitchen
import com.rentreadychecklist.model.laundry.LaundryRoom
import com.rentreadychecklist.model.livingRoom.LivingRoom
import com.rentreadychecklist.model.miscellaneous.Miscellaneous
import com.rentreadychecklist.model.outside.Outside

@Database(entities = [AppData::class], version = 1  , exportSchema = true)
@TypeConverters(FormTypeConvertorHomeScreen::class,FormTypeConvertorOutside::class,FormTypeConvertorFrontDoors::class,FormTypeConvertorGarage::class,
FormTypeConvertorLaundryRoom::class,FormTypeConvertorLivingRoom::class,FormTypeConvertorGreatRoom::class,
FormTypeConvertorDiningRoom::class,FormTypeConvertorKitchen::class,FormTypeConvertorMiscellaneous::class,
FormTypeConvertorBedrooms::class,FormTypeConvertorBathroom::class)

abstract class RoomAppDb: RoomDatabase() {

    abstract fun userDao(): AppDao?

    companion object {

        @Volatile
        private var INSTANCE: RoomAppDb? = null

        fun getAppDatabase(context: Context): RoomAppDb {
            val tempInstance= INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, RoomAppDb::class.java,"AppDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}

class FormTypeConvertorHomeScreen
{
    @TypeConverter
    fun listToJsonString(value: List<HomeScreen>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<HomeScreen>::class.java).toList()

}


class FormTypeConvertorOutside
{
    @TypeConverter
    fun listToJsonString(value: List<Outside>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Outside>::class.java).toList()

}

class FormTypeConvertorFrontDoors
{
    @TypeConverter
    fun listToJsonString(value: List<FrontDoors>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<FrontDoors>::class.java).toList()

}

class FormTypeConvertorGarage
{
    @TypeConverter
    fun listToJsonString(value: List<Garage>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Garage>::class.java).toList()

}

class FormTypeConvertorLaundryRoom
{
    @TypeConverter
    fun listToJsonString(value: List<LaundryRoom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<LaundryRoom>::class.java).toList()

}

class FormTypeConvertorLivingRoom
{
    @TypeConverter
    fun listToJsonString(value: List<LivingRoom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<LivingRoom>::class.java).toList()

}

class FormTypeConvertorGreatRoom
{
    @TypeConverter
    fun listToJsonString(value: List<GreatRoom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<GreatRoom>::class.java).toList()

}

class FormTypeConvertorDiningRoom
{
    @TypeConverter
    fun listToJsonString(value: List<DiningRoom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<DiningRoom>::class.java).toList()

}

class FormTypeConvertorKitchen
{
    @TypeConverter
    fun listToJsonString(value: List<Kitchen>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Kitchen>::class.java).toList()

}

class FormTypeConvertorMiscellaneous
{
    @TypeConverter
    fun listToJsonString(value: List<Miscellaneous>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Miscellaneous>::class.java).toList()

}

class FormTypeConvertorBedrooms
{
    @TypeConverter
    fun listToJsonString(value: List<Bedroom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Bedroom>::class.java).toList()

}

class FormTypeConvertorBathroom
{
    @TypeConverter
    fun listToJsonString(value: List<Bathroom>?): String?= Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<Bathroom>::class.java).toList()

}


