package com.example.kursovayatbd.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "visitor")
data class VisitorEntity (
    @PrimaryKey
    val idVisit: Int,
    val nameVisit: String,
    val surname: String,
    val address: String,
    val phoneNumber: String
):Serializable