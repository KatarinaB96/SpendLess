package com.campus.spendless.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.campus.spendless.autentication.data.UserDao
import com.campus.spendless.autentication.data.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class SpendLessDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}