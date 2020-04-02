package com.sample.app.firebase.models

// Plain model object which represent data entity of cell from recycler view
data class Feed(
    val id: String,
    val title: String,
    val deadline: String
) {

    constructor(): this("", "", "") {}

}
