package com.example.lab4.controllers;


import com.example.lab4.models.dto.MovieRequest;
import com.example.lab4.services.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAll() {
        return movieService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody MovieRequest movieRequest) {

        return movieService.create(movieRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return movieService.delete(id);
    }

}
