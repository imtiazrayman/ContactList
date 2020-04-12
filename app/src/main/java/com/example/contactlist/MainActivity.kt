package com.example.contactlist

import android.content.Intent
import android.graphics.Color
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
            textView.append("\nName : ${i.name}\n PhoneNumber: ${i.phoneNumber}\n   Birthday : ${i.birthday}\n")
            /*var rndR = (0..255).random()
            var rndG = (0..255).random()
            var rndB = (0..255).random()
            textView.setBackgroundColor(Color.rgb(rndR,rndG, rndB))*/ // was gonna try to make each contact have a unique color.

        }
    }

    fun addContactActivity(view: View) {
        val myIntent= Intent(this, addContact::class.java)
        startActivity(myIntent)
    }

    fun modifyActivity(view: View) {
        val myIntent= Intent(this, modifyContact::class.java)
        startActivity(myIntent)
    }

    fun deleteActivity(view: View) {
        val myIntent= Intent(this, deleteContact::class.java)
        startActivity(myIntent)
    }

}
