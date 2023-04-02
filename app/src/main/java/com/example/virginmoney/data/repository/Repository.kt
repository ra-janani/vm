package com.example.virginmoney.data.repository

import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.RoomsItemModel

interface Repository {
    suspend fun getPeople():ArrayList<PeopleItemModel>
    suspend fun getRooms(): ArrayList<RoomsItemModel>
}