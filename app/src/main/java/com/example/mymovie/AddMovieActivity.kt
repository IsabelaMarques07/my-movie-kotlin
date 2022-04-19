package com.example.mymovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mymovie.model.Movie

class AddMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        val etName: TextView = findViewById(R.id.etName)
        val etAuthor: TextView = findViewById(R.id.etAuthor)
        val etDescription: TextView = findViewById(R.id.etDescription)
        val etYear: TextView = findViewById(R.id.etYear)

        val btAdicionar: Button = findViewById(R.id.btAdd)
        btAdicionar.setOnClickListener{
            Database.data.add(Movie(etName.text.toString(), etAuthor.text.toString(), etDescription.text.toString(), etYear.text.toString()))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}