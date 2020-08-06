package com.example.databindingobservablefield.ui.main.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingobservablefield.ui.main.recyclerview.model.Customer

class CustomerViewModel : ViewModel() {

    val customerList = arrayListOf<Customer>(
        Customer("Rama", 24, true),
        Customer("Venkatesh", 65, true),
        Customer("Shailaja", 61, false)
    )

    val increaseQtyLiveData = MutableLiveData<Int>()

    fun increaseQuantity(position : Int){
        increaseQtyLiveData.postValue(position)
    }

    fun getGender(isMale : Boolean) : String{
        return if (isMale) "Male" else "Female"
    }
}
