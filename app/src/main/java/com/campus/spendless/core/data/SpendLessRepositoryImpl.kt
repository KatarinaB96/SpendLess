package com.campus.spendless.core.data

import com.campus.spendless.autentication.data.UserDao
import com.campus.spendless.core.domain.SpendLessRepository
import com.campus.spendless.core.domain.models.User

class SpendLessRepositoryImpl(private val dao: UserDao) : SpendLessRepository {
    override suspend fun insertUser(user: User) {
        dao.insertUser(user.toEntityModel())
    }

    override suspend fun getUser(userName: String): User? {
        return dao.getUser(userName)?.toDomainModel()
    }

}