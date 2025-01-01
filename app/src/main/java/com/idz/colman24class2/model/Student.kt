package com.idz.colman24class2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String,
    var isChecked: Boolean
)
