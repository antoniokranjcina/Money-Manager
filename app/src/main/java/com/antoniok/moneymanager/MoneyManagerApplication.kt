package com.antoniok.moneymanager

import android.app.Application
import com.antoniok.core.data.dataModule
import com.antoniok.core.database.databaseModule
import com.antoniok.feature.dashboard.dashboardModule
import com.antoniok.feature.newentry.addTransactionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val modules = listOf(
    // Feature
    dashboardModule,
    addTransactionModule,
    databaseModule,
    dataModule
)

class MoneyManagerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MoneyManagerApplication)
            koin.loadModules(modules)
        }
    }

}
