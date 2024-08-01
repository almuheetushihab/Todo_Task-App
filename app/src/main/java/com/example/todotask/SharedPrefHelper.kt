package com.example.todotask

import android.content.Context
import android.content.SharedPreferences


class SharedPrefHelper(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("TodoSharedPref", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()

    private val key = "tasks"
    private val value = "todo"

    fun saveTask(tasks: List<Todo>) {
        editor.putString(key, tasks.toString())
        editor.apply()

    }

    fun getTasks(): List<Todo> {
        val tasksString = sharedPref.getString(key, null)


    } 





}







