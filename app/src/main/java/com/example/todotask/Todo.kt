package com.example.todotask

import java.io.Serializable

data class Todo(
    val name: String,
    val details: String,
    val time: String,
): Serializable
