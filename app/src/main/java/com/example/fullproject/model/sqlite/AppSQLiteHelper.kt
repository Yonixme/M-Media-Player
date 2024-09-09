package com.example.fullproject.model.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppSQLiteHelper (private val applicationContext: Context) : SQLiteOpenHelper(applicationContext,
    "database.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql = applicationContext.assets.open("first_db.sql").bufferedReader().use {
            it.readText()
        }
        sql.split(";")
            .filter { it.isNotBlank() }
            .forEach {
                db.execSQL(it)
            }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) = Unit
}