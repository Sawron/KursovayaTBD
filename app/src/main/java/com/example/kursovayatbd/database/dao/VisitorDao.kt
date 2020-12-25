package com.example.kursovayatbd.database.dao

import androidx.room.*
import com.example.kursovayatbd.database.entity.VisitorEntity

@Dao
interface VisitorDao {

    @Query("select * from visitor")
    fun getAllVisitors(): List<VisitorEntity>


    @Insert
    fun insertVisitorEntity(visitorEntity: VisitorEntity)

    @Update
    fun updateVisitorEntity(visitorEntity: VisitorEntity)

    @Delete
    fun deleteVisitorEntity(visitorEntity: VisitorEntity)
}