package com.example.wrench.service


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.wrench.databinding.FragmentWrenchServiceBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class WrenchServiceFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WrenchServiceFragmentViewModel> { viewModelFactory }

    private lateinit var binding: FragmentWrenchServiceBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWrenchServiceBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}
