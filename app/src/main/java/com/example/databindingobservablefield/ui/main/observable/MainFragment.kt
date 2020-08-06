package com.example.databindingobservablefield.ui.main.observable

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.databindingobservablefield.R
import com.example.databindingobservablefield.databinding.MainFragmentBinding
import com.example.databindingobservablefield.ui.main.observable.models.ContactInfo
import com.example.databindingobservablefield.ui.main.observable.models.User

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }
    private lateinit var viewModel: MainViewModel
    private lateinit var bindingView : MainFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        bindingView = DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)
        return bindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.userDetailsObservable.set(User("Ram", "Joshi"))
        viewModel.contactInfoObservable.set(ContactInfo("88677", "Bijapur"))
        bindingView.viewModel = viewModel
    }

}
