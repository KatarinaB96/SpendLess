package com.campus.spendless.core.utils

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object SpendLessGraph : Route

    @Serializable
    data object RegistrationScreen : Route

    @Serializable
    data object PinScreen : Route
}