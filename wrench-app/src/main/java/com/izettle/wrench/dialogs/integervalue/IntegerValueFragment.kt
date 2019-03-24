package com.izettle.wrench.dialogs.integervalue

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.izettle.wrench.R
import kotlinx.android.synthetic.main.fragment_integer_value.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class IntegerValueFragment : DialogFragment() {

    private val viewModel: FragmentIntegerValueViewModel by viewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        assert(arguments != null)

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_integer_value, null)

        val args = IntegerValueFragmentArgs.fromBundle(arguments!!)

        viewModel.init(args.configurationId, args.scopeId)

        viewModel.viewState.observe(this, Observer { viewState ->
            if (viewState != null) {
                val invisible = (view.container.visibility == View.INVISIBLE)
                if (view.container.visibility == View.INVISIBLE && viewState.title != null) {
                    view.container.visibility = View.VISIBLE
                }
                view.title.text = viewState.title
                view.value.setText(viewState.value)
                if (invisible) {
                    view.value.jumpDrawablesToCurrentState()
                }

                if (viewState.saving || viewState.reverting) {
                    view.value.isEnabled = false
                    view.save.isEnabled = false
                    view.revert.isEnabled = false
                }
            }
        })

        viewModel.viewEffects.observe(this, Observer { viewEffect ->
            if (viewEffect != null) {
                viewEffect.getContentIfNotHandled()?.let { contentIfNotHandled ->
                    when (contentIfNotHandled) {
                        ViewEffect.Dismiss -> dismiss()
                    }
                }
            }
        })

        view.revert.setOnClickListener {
            viewModel.revertClick()
        }

        // view.value.setOnCheckedChangeListener { _, isChecked -> viewModel.checkedChanged(isChecked) }

        view.save.setOnClickListener {
            viewModel.saveClick(view.value.text.toString())
        }

        return AlertDialog.Builder(requireActivity())
                .setView(view)
                .create()
    }

    companion object {

        fun newInstance(args: IntegerValueFragmentArgs): IntegerValueFragment {
            val fragment = IntegerValueFragment()
            fragment.arguments = args.toBundle()
            return fragment
        }
    }
}
