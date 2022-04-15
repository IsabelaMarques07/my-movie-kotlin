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

        Database.data.addAll(
            listOf(
                Movie(name = "Spider Man Far From Home", author = "Jon Watts", description = "Homem-Aranha: Sem Volta Para Casa, Peter Parker é desmascarado e não consegue mais separar sua vida normal dos grandes riscos de ser um super-herói. Quando ele pede ajuda ao Doutor Estranho, os riscos se tornam ainda mais perigosos, e o forçam a descobrir o que realmente significa ser o Homem-Aranha.", year = 2019),
                Movie(name = "Batman", author = "Matt Reeves", description = "Após a perda de seus pais, Bruce Wayne acaba se tornando um vigilante na cidade de Gotham City.", year = 2022),
                Movie(name = "Harry Potter: De Volta a Hogwarts", author = "Casey Patterson", description = "O tempo passou, e a saga do menino que viveu para enfrentar Lord Voldemort completou 20 anos! E pra comemorar em grande estilo, nada melhor do que reunir todo o elenco. Participe desse reencontro mágico, e reviva a história que marcou toda uma geração.", year = 2022)
            )
        )

        createRecyclerViewAdapter()

        button.setOnClickListener {
            // adicionando outro item na lista
            //Database.data.add(Movie(name = "Lord of the Rings", author = "someone", description = "good movie", year = 2022))
            //createRecyclerViewAdapter()
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