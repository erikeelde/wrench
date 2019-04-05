package com.izettle.wrench.dialogs.booleanvalue

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.izettle.wrench.database.WrenchDatabase
import com.izettle.wrench.di.sampleAppModule
import com.izettle.wrench.provider.IPackageManagerWrapper
import com.izettle.wrench.provider.TestPackageManagerWrapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
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

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FragmentBooleanValueViewModelTest : AutoCloseKoinTest() {

    private val viewModel: FragmentBooleanValueViewModel by inject()

    @Before
    fun setUp() {
        startKoin(listOf(sampleAppModule, roomTestModule))
    }

    @Test
    fun `test checked changed`() = runBlocking {
        viewModel.viewState.value = ViewState("", enabled = true, saving = false, reverting = false)
        assertTrue(viewModel.viewState.value!!.enabled!!)
        viewModel.checkedChanged(false)
        assertFalse(viewModel.viewState.value!!.enabled!!)
        viewModel.checkedChanged(true)
        assertTrue(viewModel.viewState.value!!.enabled!!)
    }

    @Test
    fun `test saving`() = runBlocking {
        viewModel.init(1, 1)

        viewModel.viewState.observeForever { val lol = "" }
        viewModel.viewEffects.observeForever { val lol = "" }

        viewModel.viewState.value = ViewState("", enabled = false, saving = false, reverting = false)
        assertFalse(viewModel.viewState.value!!.enabled!!)
        viewModel.saveClick(true.toString())
        // https://issuetracker.google.com/issues/124781244
        assertTrue(viewModel.viewState.value!!.enabled!!)
    }

    @Test
    fun `test reverting`() = runBlocking {
        viewModel.viewState.value = ViewState("", enabled = true, saving = false, reverting = false)
        assertTrue(viewModel.viewState.value!!.enabled!!)
        viewModel.checkedChanged(false)
        assertFalse(viewModel.viewState.value!!.enabled!!)
        viewModel.checkedChanged(true)
        assertTrue(viewModel.viewState.value!!.enabled!!)
    }
}