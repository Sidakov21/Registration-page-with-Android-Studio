package com.example.registrationpage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.lifecycle.ViewModelProvider

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE Users (id int primary key, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query) //Обработка значения null
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("Users", null, values)

        db.close()
    }

    fun getUser(login: String, pass: String) : Boolean{
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM USERS WHERE login = '$login' AND pass = '$pass'", null)
        return result.moveToFirst() //Если запись существует то вернет true
    }


}