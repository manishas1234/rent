package com.rentreadychecklist.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rentreadychecklist.constants.Constants.Companion.FORMID
import com.rentreadychecklist.db.AppData
import com.rentreadychecklist.db.RoomAppDb
import com.rentreadychecklist.model.homescreen.HomeScreen
import com.rentreadychecklist.model.outside.Outside
import com.rentreadychecklist.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(app:Application):AndroidViewModel(app)
{
    val readFormData: LiveData<List<AppData>>
    lateinit var  readFormDataID:LiveData<List<AppData>>
    private val repository:AppRepository


    init {
        val dao= RoomAppDb.getAppDatabase(getApplication()).userDao()
        repository= dao?.let { AppRepository(it) }!!
        readFormData = repository.readFormData
        readFormDataID=repository.readFormDataID
    }


    fun insertFormInfo(formData:AppData)
    {
        viewModelScope.launch(

        )
        {

            FORMID = repository.addFormData(formData)
           // FORMID = getId.value!!


        }


    }

    fun updateOutside(List: List<Outside>,FormId:Long) {
        viewModelScope.launch(Dispatchers.IO) {

            repository.updateOutside(List, FormId)
        }
    }

    fun updateHomeScreen(List: List<HomeScreen>,FormId:Long) {
        viewModelScope.launch(Dispatchers.IO) {

            repository.updateHomeScreen(List,FormId)
        }
    }

    /*fun addFormDataId(formId: Long):LiveData<AppData>
    {


        viewModelScope.launch() {

            readFormDataID = repository.addFormDataId(formId)
        }
        return readFormDataID

    }*/



}