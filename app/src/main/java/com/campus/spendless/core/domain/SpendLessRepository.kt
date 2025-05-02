package com.campus.spendless.core.domain

import com.campus.spendless.core.domain.models.User

interface SpendLessRepository {
    suspend fun insertUser(user: User)
    suspend fun getUser(userName: String):User?
}