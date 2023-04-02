package com.example.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(val repository: Repository): ViewModel() {

    val rooms=MutableLiveData<ArrayList<RoomsItemModel>>()

    fun getRoomsData(){
        viewModelScope.launch {
            val repository=repository.getRooms()
            rooms.postValue(repository)
        }
    }
}