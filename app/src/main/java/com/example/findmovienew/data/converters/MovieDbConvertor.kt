package com.example.findmovienew.data.converters

import com.example.findmovienew.data.db.entity.MovieEntity
import com.example.findmovienew.data.dto.MovieDto
import com.example.findmovienew.domain.models.Movie

class MovieDbConvertor {

    fun map(movie: MovieDto): MovieEntity {
        return MovieEntity(movie.id, movie.resultType, movie.image, movie.title, movie.description
        )
    }

    fun map(movie: MovieEntity): Movie {
        return Movie(movie.id, movie.resultType, movie.image, movie.title, movie.description)
    }
}