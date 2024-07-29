package com.example.todotask

import java.io.Serializable

data class Todo(
    var name: String,
    var details: String,
    var time: String,
): Serializable
