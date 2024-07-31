package com.example.todotask

import java.io.Serializable

data class Todo(
    var id : String,
    var name: String,
    var details: String,
    var time: String

): Serializable
