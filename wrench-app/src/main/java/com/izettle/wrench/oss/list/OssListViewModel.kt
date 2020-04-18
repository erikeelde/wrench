package com.izettle.wrench.oss.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.izettle.wrench.oss.LicenceMetadata
import javax.inject.Inject

class OssListViewModel @Inject internal constructor(val context: Context) : ViewModel() {
    fun getThirdPartyMetadata(): LiveData<List<LicenceMetadata>> {
        return ThirdPartyLicenceMetadataLiveData(context)
    }
}
