package com.example.contactlist

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CalendarView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_calender.*

class modifyContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

    }
    inner class myAsync: AsyncTask<Contact, Unit, Unit>() {
        override fun doInBackground(vararg p0: Contact) {
            val myDb= DataBaseManager(applicationContext)
            myDb.writableDatabase
            myDb.modify(p0[0])
            return
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            finish()
        }
    }

    fun modifyInfo(view: View) {
        if(TextUtils.isEmpty(phoneEntrytoModify.text))
        {
            phoneEntrytoModify.setHint("MUST PUT IN VALUE!")
            return
        }
        if(TextUtils.isEmpty(nameEntrytoModify.text))
        {
            nameEntrytoModify.setHint("MUST PUT IN VALUE")
            return
        }

        myAsync().execute(Contact(phoneEntrytoModify.text.toString().toInt(), nameEntrytoModify.text.toString(), null))

    }



    fun cancelModify(view: View) {
        finish()
    }

}
