package com.example.databindingobservablefield.ui.main.recyclerviewObservable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingobservablefield.R
import com.example.databindingobservablefield.databinding.ActivityCustomerListBinding
import com.example.databindingobservablefield.ui.main.recyclerview.model.Customer

class CustomerListObservableActivity : AppCompatActivity() {

    private lateinit var viewModel: CustomerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_list)

        val binding : ActivityCustomerListBinding  = DataBindingUtil.setContentView(
            this,
            R.layout.activity_customer_list
        )
        binding.lifecycleOwner = this
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this).get(CustomerViewModel::class.java)

        val adapter = CustomerListAdapter(viewModel)
        binding.recyclerviewCustomerList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerviewCustomerList.adapter = adapter

        viewModel.increaseQtyLiveData.observe(this, Observer{position ->
            adapter.increaseQuantity(position)
        })
    }
}
