package com.izettle.wrench.oss.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.izettle.wrench.databinding.FragmentOssBinding
import com.izettle.wrench.oss.detail.OssDetailFragment
import com.izettle.wrench.oss.detail.OssDetailFragmentArgs
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class OssFragment : DaggerFragment() {
    private lateinit var binding: FragmentOssBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<OssListViewModel> { viewModelFactory }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentOssBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = OssRecyclerViewAdapter(clickCallback = {
            Log.d("Tag", "dependency = " + it.dependency)
            val ossDetailFragmentArgs = OssDetailFragmentArgs.Builder(it.dependency, it.skipBytes.toInt(), it.length).build()
            OssDetailFragment.newInstance(ossDetailFragmentArgs).show(childFragmentManager, "OssDetails")
        })
        binding.recView.adapter = adapter

        viewModel.getThirdPartyMetadata().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}
