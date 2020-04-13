package com.example.contactlist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val TABLE_CONTACTS = "Contacts"
val PHONENUMBER = "Phone_Number"
val NAME = "Contact_Name"
val BIRTHDAY = "Contact_Birthday"

class DataBaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Contacts.db"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS ${TABLE_CONTACTS} (" +
                    "${PHONENUMBER} INTEGER PRIMARY KEY, " +
                    "${NAME} TEXT, ${BIRTHDAY} TEXT)"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists $TABLE_CONTACTS")
        onCreate(p0)
    }

    fun insert(contactToInsert: Contact) {
        val db = this.writableDatabase
        val insertString = "INSERT INTO $TABLE_CONTACTS " +
                "VALUES ('${contactToInsert.phoneNumber}', '${contactToInsert.name}', '${contactToInsert.birthday}')"
        db.execSQL(insertString)
    }

    fun selectAll(): ArrayList<Contact> {
        val sqlQuery = "select * from $TABLE_CONTACTS"

        val db = this.writableDatabase
        var toReturn = ArrayList<Contact>()
        var cursor = db.rawQuery(sqlQuery, null)
        while (cursor.moveToNext()) {
            toReturn.add(Contact(cursor.getInt(0), cursor.getString(1), cursor.getString(2)))

        }
        return toReturn
    }

    fun delete(contactToInsert: Contact) {
        val db = this.writableDatabase
        val deleteString = "DELETE FROM $TABLE_CONTACTS " +
                "WHERE ${PHONENUMBER} = ${contactToInsert.phoneNumber}"
        db.execSQL(deleteString)
    }

    fun modify(contactToInsert: Contact) {
        val db = this.writableDatabase
        val modifyString = "UPDATE $TABLE_CONTACTS " +
                "SET ${NAME} = '${contactToInsert.name}' " +
                "WHERE ${PHONENUMBER} = ${contactToInsert.phoneNumber}"
        db.execSQL(modifyString)
    }

}


