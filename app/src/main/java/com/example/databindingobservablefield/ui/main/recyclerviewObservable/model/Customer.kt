package com.example.databindingobservablefield.ui.main.recyclerviewObservable.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.databindingobservablefield.BR

class Customer(
    private var name: String,
    private var age: Int,
    private var isGenderMale: Boolean
) : BaseObservable() {

    var clientName: String
        @Bindable get() = name
        set(value) {
            name = value
            notifyPropertyChanged(BR.clientName)
        }


    var clientAge: Int
        @Bindable get() = age
        set(value) {
            age = value
            notifyPropertyChanged(BR.clientAge)
        }

    val isMale: Boolean
        get() = isGenderMale

}

