package com.example.mymovie.model

import java.io.Serializable

data class Movie(
    val name: String,
    val author: String,
    val description: String,
    val year: String,
):Serializable
