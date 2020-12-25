package com.example.kursovayatbd.database.serializable_data

import com.example.kursovayatbd.database.entity.VisitorEntity
import java.io.Serializable

data class DataVisitors (
    val visitors: List<VisitorEntity>
): Serializable