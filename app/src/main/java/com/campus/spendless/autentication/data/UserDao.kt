package com.campus.spendless.autentication.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.campus.spendless.autentication.data.entity.UserEntity

@Dao
interface UserDao {
    @Upsert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM USER WHERE username=:username")
    suspend fun getUser(username: String): UserEntity?
}