package com.example.contactlist

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_calender.*

class addContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
        imageView.setImageResource(R.drawable.sampleprofile)

        calendarView.setOnDateChangeListener { calendarView, y, m, d ->
            var months = m + 1
            var birthday = months.toString() +"/" +  d.toString() +"/" + y.toString()
            txtBirthdayDisplay.text = birthday
        }
    }


    inner class myAsync: AsyncTask<Contact, Unit, Unit>() {
        override fun doInBackground(vararg p0: Contact) {
            val myDb= DataBaseManager(applicationContext)
            myDb.writableDatabase
            myDb.insert(p0[0])
            return
        }
        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // slide back to the main activity
        }
    }

    fun newContactAdded(view: View) { // this is the button when the user confirms the date of birth name and phone number.

        if(TextUtils.isEmpty(nameEntry.text))
        {
            nameEntry.setHint("MUST PUT IN VALUE!")
            Toast.makeText(
                this@addContact,
                "You must Enter a Name",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if(TextUtils.isEmpty(phoneEntry.text))
        {
            phoneEntry.setHint("MUST PUT IN VALUE")
            Toast.makeText(
                this@addContact,
                "You must Enter a Phone Number",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        myAsync().execute(Contact(phoneEntry.text.toString().toInt(), nameEntry.text.toString(), txtBirthdayDisplay.text.toString()))
    }

    fun cancelAdd(view: View) {
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // slide back to the main activity
    }


}
