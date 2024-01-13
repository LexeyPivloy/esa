package com.example.lab1.services;

import com.example.lab1.models.MovieEntity;
import com.example.lab1.models.dto.MovieRequest;
import com.example.lab1.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class MovieService {

    @Inject
    private MovieRepository movieRepository;

    public List<MovieEntity> getAll() {return movieRepository.findAll();}

    public UUID create(MovieRequest movieRequest){
        MovieEntity movie = new MovieEntity(randomUUID(), movieRequest.getTitle(), movieRequest.getDirector_id());
        movieRepository.persist(movie);
        return movie.getId();
    }

    public void delete(UUID movie_id) {
        movieRepository.delete(movie_id);
    }
}
