package com.example.lab2.controllers;


import com.example.lab2.models.dto.MovieRequest;
import com.example.lab2.services.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<String> getAll() {
        return movieService.getAll();
    }

    @PostMapping("/movies")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody MovieRequest movieRequest) {

        return movieService.create(movieRequest);

    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return movieService.delete(id);
    }

}
