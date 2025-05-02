package com.campus.spendless.autentication.domain.impl

import com.campus.spendless.autentication.domain.GetUserUseCase
import com.campus.spendless.core.domain.SpendLessRepository
import com.campus.spendless.core.domain.models.User

class GetUserUseCaseImpl(private val spendLessRepository: SpendLessRepository):GetUserUseCase {
    override suspend fun execute(username: String): User? {
        return spendLessRepository.getUser(username)
    }
}