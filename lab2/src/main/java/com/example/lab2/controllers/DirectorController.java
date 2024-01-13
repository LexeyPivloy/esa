package com.example.lab2.controllers;

import com.example.lab2.models.dto.DirectorRequest;
import com.example.lab2.services.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/directors")
    public ResponseEntity<String> getAll() {
        return directorService.getAll();
    }

    @PostMapping("/directors")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody DirectorRequest directorRequest) {

        return directorService.create(directorRequest);

    }

    @DeleteMapping("/directors/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return directorService.delete(id);
    }

}
