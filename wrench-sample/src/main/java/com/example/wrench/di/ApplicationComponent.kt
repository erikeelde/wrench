package com.example.wrench.di

import android.content.Context
import com.example.wrench.SampleApplication
import com.example.wrench.livedataprefs.LiveDataPreferencesFragmentModule
import com.example.wrench.service.WrenchServiceFragmentModule
import com.example.wrench.wrenchprefs.WrenchPreferencesFragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ApplicationModule::class,
            AndroidSupportInjectionModule::class,
            LiveDataPreferencesFragmentModule::class,
            WrenchPreferencesFragmentModule::class,
            WrenchServiceFragmentModule::class
        ])
interface ApplicationComponent : AndroidInjector<SampleApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}