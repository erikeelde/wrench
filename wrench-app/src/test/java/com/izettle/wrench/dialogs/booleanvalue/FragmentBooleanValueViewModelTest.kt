package com.izettle.wrench.dialogs.booleanvalue

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.izettle.wrench.database.WrenchDatabase
import com.izettle.wrench.di.sampleAppModule
import com.izettle.wrench.provider.IPackageManagerWrapper
import com.izettle.wrench.provider.TestPackageManagerWrapper
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest

val roomTestModule = module {
    single(override = true) {
        // In-Memory database config
        Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), WrenchDatabase::class.java).allowMainThreadQueries().build()
    }

    single(override = true) {
        TestPackageManagerWrapper("TestApplication", "com.test.application") as IPackageManagerWrapper
    }
}

@RunWith(AndroidJUnit4::class)
class FragmentBooleanValueViewModelTest : AutoCloseKoinTest() {

    private val viewModel: FragmentBooleanValueViewModel by inject()

    @Before
    fun setUp() {
        startKoin(listOf(sampleAppModule, roomTestModule))
    }


}