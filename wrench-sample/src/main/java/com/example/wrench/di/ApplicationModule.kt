package com.example.wrench.di

import android.content.Context
import com.izettle.wrench.preferences.WrenchPreferences
import com.izettle.wrench.service.WrenchPreferenceProvider
import com.izettle.wrench.service.WrenchService
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object ApplicationModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun provideWrenchPreferences(context: Context) = WrenchPreferences(context)

    @Provides
    fun provideWrenchService(context: Context): WrenchService = WrenchService.with(WrenchPreferenceProvider(WrenchPreferences(context)))
}
