package com.example.kursovayatbd.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kursovayatbd.database.dao.VisitorDao
import com.example.kursovayatbd.database.entity.VisitorEntity


@Database(entities = [VisitorEntity::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun visitorDao(): VisitorDao
}