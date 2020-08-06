package com.example.databindingobservablefield.ui.main.recyclerviewObservable.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.databindingobservablefield.BR

class UserData(private var firstName: String, private var lastName: String) :
    BaseObservable() {

    @Bindable // makes firstName observable
    fun getFirstName(): String {
        val name = firstName + System.currentTimeMillis() % 1000
        Log.e("firstnameGet", name)
        return name
    }

    @Bindable // makes lastName observable
    fun getLastName(): String {
        val name = lastName + System.currentTimeMillis() % 1000
        Log.e("lastnameGet", name)
        return name
    }

//    fun setFirstName(firstName: String) {
//        val name = firstName + System.currentTimeMillis() % 1000
//        this.firstName = name
//        Log.e("firstnameSet", name)
//        notifyPropertyChanged(BR.firstName)
//    }
//
//    fun setLastName(lastName: String) {
//        val name = lastName + System.currentTimeMillis() % 1000
//        this.lastName = name
//        Log.e("lastnameSet", name)
//        notifyPropertyChanged(BR.lastName)
//    }

}
