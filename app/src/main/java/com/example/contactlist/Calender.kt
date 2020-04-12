package com.example.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_calender.*

class Calender : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        calendarView2.setOnDateChangeListener {calendarView2, y, m, d ->
            var months = m + 1
            var birthday = months.toString() +"/" +  d.toString() +"/" + y.toString()
            //textView3.text = "Birthday : " + birthday

            val myIntent= Intent(this, addContact::class.java)
            myIntent.putExtra("birthday" , birthday)
            startActivity(myIntent)
            finish()
            }
    }

    fun cancelCalender(view: View) {
        finish()
    }
}
