package com.example.mymovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovie.R
import com.example.mymovie.model.Movie

class MovieAdapter(
    val data: MutableList<Movie>,
    private val onClickMovieListener: (Int) -> Unit
    ): RecyclerView.Adapter<MovieAdapter.ItemViewHolder>() {

    class  ItemViewHolder(
        view: View,
        private val onClickMovieListener: (Int) -> Unit
    ): RecyclerView.ViewHolder(view), View.OnClickListener{
        private val item :View = view.findViewById(R.id.item_movie)
        val itemText: TextView = view.findViewById(R.id.item_movie_text)
        val itemYear: TextView = view.findViewById(R.id.item_movie_year)

        init{
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onClickMovieListener.invoke(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return ItemViewHolder(adapterLayout, onClickMovieListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemText.text = data[position].name
        holder.itemYear.text = data[position].year.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}