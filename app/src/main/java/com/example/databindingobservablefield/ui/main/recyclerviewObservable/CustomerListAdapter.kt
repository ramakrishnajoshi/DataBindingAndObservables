package com.example.databindingobservablefield.ui.main.recyclerviewObservable

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingobservablefield.R
import com.example.databindingobservablefield.databinding.RowCustomerListObservableBinding

class CustomerListAdapter(private val viewModel: CustomerViewModel) : RecyclerView.Adapter<CustomerListAdapter.ListViewHolder>() {

    lateinit var binding : RowCustomerListObservableBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_customer_list_observable,
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.customerList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindDataToView(/*binding,*/ position, viewModel)
    }


    fun increaseQuantity(position: Int) {
        var age = viewModel.customerList[position].clientAge
        age = age + 1
        viewModel.customerList[position].clientAge = age

        var name = viewModel.customerList[position].clientName
        name = name + "z"
        viewModel.customerList[position].clientName = name

//        viewModel.customerList[position].isMale = if (age %2 == 0) true else false
        //notifyItemChanged(position) // no need to call notifyItemChanged as Customer is Observable now
    }

    class ListViewHolder(private val binding : RowCustomerListObservableBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindDataToView(/*binding : RowCustomerListBinding, */position : Int, viewModel: CustomerViewModel){
            binding.viewModel = viewModel
            binding.customerData = viewModel.customerList[position]
            Log.e("Data",    binding.customerData.toString())
            binding.position = position
            //binding.setLifecycleOwner(binding.lifecycleOwner);
            binding.executePendingBindings()
        }
    }
}
