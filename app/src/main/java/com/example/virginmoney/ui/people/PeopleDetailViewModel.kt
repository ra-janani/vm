package com.example.virginmoney.ui.people

import androidx.lifecycle.ViewModel
import com.example.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

}