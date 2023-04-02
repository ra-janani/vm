package com.example.virginmoney.data.remote

import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.END_PT1)
   suspend fun getPeople():ArrayList<PeopleItemModel>

   @GET(ApiDetails.END_PT2)
   suspend fun getRooms(): ArrayList<RoomsItemModel>
}