package com.example.databindingobservablefield.ui.main.recyclerview

import android.content.ClipData.Item
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingobservablefield.R
import com.example.databindingobservablefield.databinding.RowCustomerListBinding


class CustomerListAdapter(private val viewModel: CustomerViewModel) : RecyclerView.Adapter<CustomerListAdapter.ListViewHolder>() {

    lateinit var binding : RowCustomerListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.row_customer_list, parent, false)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_customer_list,
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
        var age = viewModel.customerList[position].age
        age = age + 1
        viewModel.customerList[position].age = age

        var name = viewModel.customerList[position].name
        name = name + "z"
        viewModel.customerList[position].name = name

        viewModel.customerList[position].isMale = if (age %2 == 0) true else false
        notifyItemChanged(position)
    }

    class ListViewHolder(private val binding : RowCustomerListBinding) : RecyclerView.ViewHolder(binding.root){
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
