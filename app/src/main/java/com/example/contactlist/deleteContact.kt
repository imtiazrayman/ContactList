package com.example.contactlist

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_delete_contact.*

class deleteContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_contact)
    }
    inner class myAsync: AsyncTask<Contact, Unit, Unit>() {
        override fun doInBackground(vararg p0: Contact) {
            val myDb= DataBaseManager(applicationContext)
            myDb.writableDatabase
            myDb.delete(p0[0])
            return
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            finish()
        }
    }

    fun cancelDelete(view: View) {
        finish()
    }

    fun deleteContact(view: View) {
        if(TextUtils.isEmpty(phoneEntrytoDelete.text))
        {
            phoneEntrytoDelete.setHint("MUST PUT IN VALUE!")
            return
        }
        myAsync().execute(Contact(phoneEntrytoDelete.text.toString().toInt(), null , null))



    }

}
