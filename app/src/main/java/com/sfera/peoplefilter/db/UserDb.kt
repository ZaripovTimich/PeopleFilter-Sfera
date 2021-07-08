package com.sfera.peoplefilter.db

import android.provider.BaseColumns

object UsersDb : BaseColumns {
    const val TABLE_NAME = "users"
    const val COLUMN_NAME = "name"
    const val COLUMN_AGE = "age"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "UsersDb.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME TEXT, $COLUMN_AGE INTEGER)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}