package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.SchoolData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainViewModel: ViewModel() {
    var listData: MutableLiveData<List<SchoolData>> = MutableLiveData()
    init {
        CoroutineScope(Dispatchers.IO).launch{
            listData.postValue(RetrofitClient.api.getSchools())
        }
    }

}