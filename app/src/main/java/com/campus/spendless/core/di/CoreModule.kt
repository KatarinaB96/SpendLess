package com.campus.spendless.core.di

import androidx.room.Room
import com.campus.spendless.core.data.SpendLessDatabase
import com.campus.spendless.core.domain.SpendLessRepository
import com.campus.spendless.core.data.SpendLessRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    single { Room.databaseBuilder(get(), SpendLessDatabase::class.java, "spend_less_db.db").build() }
    single { get<SpendLessDatabase>().userDao }
    singleOf(::SpendLessRepositoryImpl).bind<SpendLessRepository>()
}