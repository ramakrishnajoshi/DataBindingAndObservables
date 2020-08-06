package com.example.databindingobservablefield.ui.main.observable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databindingobservablefield.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    MainFragment.newInstance()
                )
                .commitNow()
        }
    }
}
