package com.example.wrench.wrenchprefs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.wrench.databinding.FragmentWrenchPreferencesBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WrenchPreferencesFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WrenchPreferencesFragmentViewModel> { viewModelFactory }

    private lateinit var binding: FragmentWrenchPreferencesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWrenchPreferencesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        return binding.root
    }
}
