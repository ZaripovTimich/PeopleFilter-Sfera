package com.sfera.peoplefilter.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(
    context, UsersDb.DATABASE_NAME,
    null, UsersDb.DATABASE_VERSION
) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(UsersDb.CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(UsersDb.SQL_DELETE_TABLE)
        onCreate(p0)
    }
}