package com.example.lab3.controllers;

import com.example.lab3.services.DirectorService;
import com.example.lab3.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final DirectorService directorService;

    private final MovieService movieService;

    @GetMapping(value = "/directors_xml")
    public String getDirectors(Model model) throws Exception {
        return directorService.getDirectors(model);
    }

    @GetMapping(value = "/movies_xml")
    public String getMovies(Model model) throws Exception {
        return movieService.getMovies(model);
    }
}