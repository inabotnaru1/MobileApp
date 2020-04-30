package com.sample.app.model

data class Task(
    val id: String,
    val title: String,
    val deadline: String
)
{
    constructor(): this(
        "",
        "",
        ""
    )
}
