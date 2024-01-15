package com.example.lab4.services;

import com.example.lab4.models.MovieEntity;
import com.example.lab4.models.dto.MovieRequest;
import com.example.lab4.repositories.MovieRepository;
import com.example.lab4.utils.ObjectToDomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
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

    public String getMovies(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("movies");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<MovieEntity> movies = movieRepository.findAll();
        for (MovieEntity movie : movies) {

            transformer.transform(element, movie, "movie");
        }

        model.addAttribute("movies", element);
        return "movies";
    }

}
