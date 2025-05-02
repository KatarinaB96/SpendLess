package com.campus.spendless

import android.app.Application
import com.campus.spendless.autentication.di.authenticationModule
import com.campus.spendless.core.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpendLessApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SpendLessApplication)
            modules(coreModule, authenticationModule)
        }
    }
}