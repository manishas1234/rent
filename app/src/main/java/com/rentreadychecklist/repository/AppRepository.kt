package com.rentreadychecklist.repository

import androidx.lifecycle.LiveData
import com.rentreadychecklist.constants.Constants.Companion.FORMID
import com.rentreadychecklist.db.AppDao
import com.rentreadychecklist.db.AppData
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.outside.Outside
import java.text.Normalizer
import java.util.concurrent.Callable

class AppRepository(private val dao: AppDao) {

    val readFormData: LiveData<List<AppData>> = dao.getAllFormInfo()
    val readFormDataID:LiveData<List<AppData>> = dao.getFormInfoID(formId = FORMID)


    suspend fun addFormData(formData:AppData):Long {
        return dao.insertForm(formData)
    }

   /* suspend fun addFormDataId(formId: Long):LiveData<AppData>
    {
        return dao.getFormInfoID(formId)
    }*/



    suspend fun updateOutside(List:List<Outside>,formId:Long)
    {
        dao.updateOutside(List,formId)
    }

    suspend fun updateHomeScreen(List:List<HomeScreen>,formId:Long)
    {
        dao.updateHomeScreen(List,formId)
    }





}