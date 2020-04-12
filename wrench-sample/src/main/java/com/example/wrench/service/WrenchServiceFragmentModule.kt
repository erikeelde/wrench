package com.example.wrench.service

import androidx.lifecycle.ViewModel
import com.example.wrench.di.ViewModelBuilder
import com.example.wrench.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class WrenchServiceFragmentModule {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun wrenchPreferenceFragment(): WrenchServiceFragment

    @Binds
    @IntoMap
    @ViewModelKey(WrenchServiceFragmentViewModel::class)
    abstract fun bindViewModel(viewmodel: WrenchServiceFragmentViewModel): ViewModel
}
