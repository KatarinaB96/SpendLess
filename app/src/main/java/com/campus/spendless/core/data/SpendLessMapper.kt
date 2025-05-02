package com.campus.spendless.core.data

import com.campus.spendless.autentication.data.entity.UserEntity
import com.campus.spendless.core.domain.models.User

fun User.toEntityModel(): UserEntity {
    return UserEntity(
        id = id,
        username = username,
        pin = pin
    )
}

fun UserEntity.toDomainModel(): User {
    return User(
        id = id,
        username = username,
        pin = pin
    )
}