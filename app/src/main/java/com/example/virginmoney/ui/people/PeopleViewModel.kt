package com.example.virginmoney.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(val repository: Repository): ViewModel() {

    val people=MutableLiveData<ArrayList<PeopleItemModel>>()

    fun getPeopleData(){
        viewModelScope.launch {
            val repository=repository.getPeople()
            people.postValue(repository)
        }
    }
}