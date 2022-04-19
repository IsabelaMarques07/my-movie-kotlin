package com.example.mymovie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovie.adapter.MovieAdapter
import com.example.mymovie.model.Movie
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_movies)
        val button: FloatingActionButton = findViewById(R.id.add_movie)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(baseContext, LinearLayoutManager.VERTICAL))

        createRecyclerViewAdapter()

        button.setOnClickListener {
            val intent = Intent(this, AddMovieActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createRecyclerViewAdapter() {
        recyclerView.adapter = MovieAdapter(Database.data, this::onMovieClickLister)
    }

    fun onMovieClickLister(position: Int) {
        val intent = Intent(this, ViewMovieActivity::class.java)
        intent.putExtra("data", Database.data[position])
        startActivity(intent)
    }
}