package com.example.databindingobservablefield.ui.main.observable

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.databindingobservablefield.ui.main.observable.models.ContactInfo
import com.example.databindingobservablefield.ui.main.observable.models.User
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val userDetailsObservable = ObservableField<User>()
    val contactInfoObservable = ObservableField<ContactInfo>()

    fun onChangeNameButtonClicked(){
        userDetailsObservable.get()?.firstName = "Ramakrishna ${Random.nextInt()}"
        userDetailsObservable.notifyChange()
    }

//    fun getContactNumber() : ObservableField<String>{
    fun getContactNumber() : String{
//        return ObservableField(contactInfoObservable.get()?.phoneNumber ?: "")
        return contactInfoObservable.get()?.phoneNumber ?: ""
    }

    fun onChangePhoneNUmberButtonClicked(){
        contactInfoObservable.get()?.phoneNumber = "866012 ${Random.nextInt()}"
        contactInfoObservable.notifyChange()
    }
}
