package com.antoniok.moneymanager

import android.app.Application
import com.antoniok.core.data.dataModule
import com.antoniok.core.database.databaseModule
import com.antoniok.core.domain.domainModule
import com.antoniok.feature.addtransaction.addTransactionModule
import com.antoniok.feature.dashboard.dashboardModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val modules = listOf(
    databaseModule,
    dataModule,
    domainModule,
    // Feature
    dashboardModule,
    addTransactionModule,
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
