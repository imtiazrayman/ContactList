package com.example.contactlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateView()
    }
    override fun onResume() {
        super.onResume()
        updateView()
    }

    fun updateView():Unit
    {
        textView.text= ""
        val myDb= DataBaseManager(applicationContext)
        myDb.writableDatabase
        val listToDispay = myDb.selectAll()
        for(i in listToDispay)
        {
            textView.append("Name : ${i.name}  PhoneNumber: ${i.phoneNumber}   Birthday : ${i.birthday}\n")
        }
    }

    fun addContactActivity(view: View) {
        val myIntent= Intent(this, addContact::class.java)
        startActivity(myIntent)
    }

    fun modifyActivity(view: View) {}

}
