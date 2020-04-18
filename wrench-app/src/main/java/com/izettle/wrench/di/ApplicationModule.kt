package com.izettle.wrench.di

import android.content.Context
import androidx.room.Room
import com.izettle.wrench.database.WrenchDatabase
import com.izettle.wrench.database.migrations.Migrations
import com.izettle.wrench.preferences.WrenchPreferences
import com.izettle.wrench.provider.IPackageManagerWrapper
import com.izettle.wrench.provider.PackageManagerWrapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideWrenchDb(context: Context): WrenchDatabase {
        return Room.databaseBuilder(context, WrenchDatabase::class.java, "wrench_database.db")
                .addMigrations(Migrations.MIGRATION_1_2)
                .addMigrations(Migrations.MIGRATION_2_3)
                .build()
    }

    @Singleton
    @Provides
    fun provideWrenchApplicationDao(wrenchDatabase: WrenchDatabase) = wrenchDatabase.applicationDao()

    @Singleton
    @Provides
    fun provideWrenchConfigurationDao(wrenchDatabase: WrenchDatabase) = wrenchDatabase.configurationDao()

    @Singleton
    @Provides
    fun provideWrenchConfigurationValueDao(wrenchDatabase: WrenchDatabase) = wrenchDatabase.configurationValueDao()

    @Singleton
    @Provides
    fun provideWrenchScopeDao(wrenchDatabase: WrenchDatabase) = wrenchDatabase.scopeDao()

    @Singleton
    @Provides
    fun providePredefinedConfigurationValueDao(wrenchDatabase: WrenchDatabase) = wrenchDatabase.predefinedConfigurationValueDao()

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun providePackageManagerWrapper(context: Context): IPackageManagerWrapper = PackageManagerWrapper(context.packageManager)

    @Provides
    fun providesWrenchPreferences(context: Context) = WrenchPreferences(context)
}
