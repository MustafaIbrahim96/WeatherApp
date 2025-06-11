package com.mustafa.weatherapp

import android.app.Application
import com.mustafa.weatherapp.di.dataModule
import com.mustafa.weatherapp.di.networkModule
import com.mustafa.weatherapp.di.repositoryModule
import com.mustafa.weatherapp.di.useCaseModule
import com.mustafa.weatherapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                dataModule(this@MyApplication),
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}