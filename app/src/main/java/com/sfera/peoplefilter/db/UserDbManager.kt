package com.sfera.peoplefilter.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sfera.peoplefilter.User

class UsersDbManager(context: Context) {
    private val dbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = dbHelper.writableDatabase
        db?.delete(UsersDb.TABLE_NAME, null, null)
    }

    fun insertToDb(name: String, age: Int) {
        val values = ContentValues().apply {
            put(UsersDb.COLUMN_NAME, name)
            put(UsersDb.COLUMN_AGE, age)
        }
        db?.insert(UsersDb.TABLE_NAME, null, values)
    }

    fun readDbData(): ArrayList<User> {
        val dataList = ArrayList<User>()
        val cursor = db?.query(
            UsersDb.TABLE_NAME, null, null,
            null, null,
            null, null
        )

        try {
            while (cursor?.moveToNext() == true) {
                val dataTextName = cursor.getString(cursor.getColumnIndex(UsersDb.COLUMN_NAME))
                val dataTextAge = cursor.getInt(cursor.getColumnIndex(UsersDb.COLUMN_AGE))
                dataList.add(
                    User(
                        name = dataTextName,
                        age = dataTextAge
                    )
                )
            }
        } finally {
            cursor?.close()
        }
        return dataList
    }

    fun filter(dataList: ArrayList<User>): ArrayList<User> {
        val fixDataList = ArrayList<User>()
        dataList.filter { user -> user.age > 17 }.toCollection(fixDataList)

        return fixDataList
    }
}