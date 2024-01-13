package com.example.lab1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab1.services.MovieService;
import com.example.lab1.models.dto.MovieRequest;
import com.example.lab1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "movieServlet", value = "/movies")
public class MovieServlet extends HttpServlet {

    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private MovieService movieService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(movieService.getAll()));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            MovieRequest movieRequest = objectMapper.readValue(is, MovieRequest.class);
            movieService.create(movieRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        UUID movie_id = UUID.fromString(req.getPathInfo().substring(1));
        movieService.delete(movie_id);
    }
}
