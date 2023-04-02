package com.example.virginmoney.data.repository

import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiRequest: ApiRequest):Repository{
    override suspend fun getPeople(): ArrayList<PeopleItemModel> =apiRequest.getPeople()

    override suspend fun getRooms():  ArrayList<RoomsItemModel> = apiRequest.getRooms()

}