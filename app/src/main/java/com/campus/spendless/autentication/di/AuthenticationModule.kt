package com.campus.spendless.autentication.di

import com.campus.spendless.autentication.domain.GetUserUseCase
import com.campus.spendless.autentication.domain.impl.GetUserUseCaseImpl
import com.campus.spendless.autentication.presentation.registration.RegistrationViewModel
import com.campus.spendless.core.domain.SpendLessRepository
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authenticationModule = module {
    factory<GetUserUseCase> {
        GetUserUseCaseImpl(get<SpendLessRepository>())
    }

    viewModelOf(::RegistrationViewModel)
}