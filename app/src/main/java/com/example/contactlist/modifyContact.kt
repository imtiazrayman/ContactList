package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_calender.*

class modifyContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        if(switch1.isChecked){
            findViewById<ProgressBar>(R.id.calendarView2).visibility = View.VISIBLE
        }
        else{

        }
    }

}
