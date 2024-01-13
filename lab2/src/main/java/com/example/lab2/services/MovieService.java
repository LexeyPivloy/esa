package com.example.lab2.services;

import com.example.lab2.models.MovieEntity;
import com.example.lab2.models.dto.MovieRequest;
import com.example.lab2.repositories.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final ObjectMapper objectMapper;

    private final MovieRepository movieRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(movieRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(MovieRequest movieRequest){
        MovieEntity movie = new MovieEntity(randomUUID(), movieRequest.getTitle(), movieRequest.getDirector_id());
        movieRepository.save(movie);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID movie_id) {
        movieRepository.deleteById(movie_id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
