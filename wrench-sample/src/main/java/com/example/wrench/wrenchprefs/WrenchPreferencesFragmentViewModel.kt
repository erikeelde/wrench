package com.example.wrench.wrenchprefs

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wrench.MyEnum
import com.example.wrench.R
import com.izettle.wrench.preferences.WrenchPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class WrenchPreferencesFragmentViewModel @Inject constructor(val context: Context, private val wrenchPreferences: WrenchPreferences) : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Main)

    private val stringConfig: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getStringConfiguration(): LiveData<String> {
        scope.launch {
            stringConfig.postValue(wrenchPreferences.getString(context.getString(R.string.string_configuration), "string1"))
        }
        return stringConfig
    }

    private val urlConfig: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getUrlConfiguration(): LiveData<String> {
        scope.launch {
            urlConfig.postValue(wrenchPreferences.getString(context.getString(R.string.url_configuration), "http://www.example.com/path?param=value"))
        }
        return urlConfig
    }

    private val booleanConfig: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getBooleanConfiguration(): LiveData<Boolean> {
        scope.launch {
            booleanConfig.postValue(wrenchPreferences.getBoolean(context.getString(R.string.boolean_configuration), true))
        }
        return booleanConfig
    }

    private val intConfig: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getIntConfiguration(): LiveData<Int> {
        scope.launch {
            intConfig.postValue(wrenchPreferences.getInt(context.getString(R.string.int_configuration), 1))
        }
        return intConfig

    }

    private val enumConfig: MutableLiveData<MyEnum> by lazy {
        MutableLiveData<MyEnum>()
    }

    fun getEnumConfiguration(): LiveData<MyEnum> {
        scope.launch {
            enumConfig.postValue(wrenchPreferences.getEnum(context.getString(R.string.enum_configuration), MyEnum::class.java, MyEnum.SECOND))
        }
        return enumConfig
    }
}
