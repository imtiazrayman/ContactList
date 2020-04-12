package com.example.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlin.time.days

class addContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        calendarView.setOnDateChangeListener {calendarView, y, m, d ->
            var months = m + 1
            textView2.text = "Birthday : " + months.toString() +"/" +  d.toString() +"/" + y.toString() }


    }
}
