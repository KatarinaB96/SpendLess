package com.campus.spendless.autentication.domain

import com.campus.spendless.core.domain.models.User

interface GetUserUseCase {
    suspend fun execute(username: String): User?
}