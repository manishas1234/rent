package com.rentreadychecklist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.outside.Outside


@Dao
interface AppDao {

    @Query("SELECT * FROM formInformation ORDER BY  rowId DESC")
    fun getAllFormInfo(): LiveData<List<AppData>>

   @Query("SELECT * FROM formInformation where id = :formId ")
    fun getFormInfoID(formId: Long):LiveData<List<AppData>>


    @Insert
    suspend fun insertForm(Form:AppData?): Long

    @Delete
    suspend fun deleteForm(Form: AppData?)

    @Update
    suspend fun updateForm(Form: AppData?)

    @Query("UPDATE formInformation set outside = :List WHERE id = :formId")
    suspend fun updateOutside(List:List<Outside>,formId:Long)

   @Query("UPDATE formInformation set homeScreen = :List WHERE id = :formId")
    suspend fun updateHomeScreen(List:List<HomeScreen>,formId:Long)







}