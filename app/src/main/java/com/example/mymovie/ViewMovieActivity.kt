package com.example.mymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mymovie.model.Movie

class ViewMovieActivity : AppCompatActivity() {

    private lateinit var selectionedMovie:Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)

        selectionedMovie = intent.getSerializableExtra("data") as Movie

        val tvName:TextView = findViewById(R.id.tvName)
        val tvYear:TextView = findViewById(R.id.tvYear)
        val tvAuthor:TextView = findViewById(R.id.tvAuthor)
        val tvDescription:TextView = findViewById(R.id.tvDescription)

        tvName.text = selectionedMovie.name
        tvYear.text = selectionedMovie.year.toString()
        tvAuthor.text = selectionedMovie.author
        tvDescription.text = selectionedMovie.description


    }
}