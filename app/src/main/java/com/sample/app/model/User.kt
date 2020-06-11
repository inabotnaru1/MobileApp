package com.sample.app.model

data class User(
    val name: String,
    var email: String,
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
)