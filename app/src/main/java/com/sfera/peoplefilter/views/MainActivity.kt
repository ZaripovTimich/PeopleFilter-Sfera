package com.sfera.peoplefilter.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sfera.peoplefilter.User
import com.sfera.peoplefilter.db.UsersDbManager
import com.sfera.peoplefilter.databinding.ActivityMainBinding
import com.sfera.peoplefilter.adapter.UserListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbManager = UsersDbManager(this)
        insert(dbManager)

        var adapter = UserListAdapter(dbManager.readDbData())

        binding.list.adapter = adapter

        binding.filter.setOnClickListener {
            adapter = UserListAdapter(dbManager.filter(dbManager.readDbData()))
            binding.list.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun insert(dbManager: UsersDbManager) {
        dbManager.apply {
            openDb()
            if (dbManager.readDbData().isEmpty()) {
                insertToDb("Петя", 21)
                insertToDb("Михал", 41)
                insertToDb("Ваня", 31)
                insertToDb("Игорь", 24)
                insertToDb("Карен", 10)
                insertToDb("Владимир", 9)
                insertToDb("Настя", 70)
                insertToDb("Софья", 18)
                insertToDb("Тимур", 50)
                insertToDb("Юрий", 66)
                insertToDb("Алексей", 16)
                insertToDb("Фарход", 17)
                insertToDb("Эльбек", 19)
                insertToDb("Диана", 34)
                insertToDb("Татьяна", 46)
                insertToDb("Александр", 54)
                insertToDb("Никита", 60)
                insertToDb("Елена", 13)
            }
        }
    }
}