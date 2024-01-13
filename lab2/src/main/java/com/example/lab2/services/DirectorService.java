package com.example.lab2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.lab2.repositories.DirectorRepository ;
import com.example.lab2.models.DirectorEntity;
import com.example.lab2.models.dto.DirectorRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final ObjectMapper objectMapper;

    private final DirectorRepository directorRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(directorRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(DirectorRequest directorRequest){
        DirectorEntity director = new DirectorEntity(randomUUID(), directorRequest.getName());
        directorRepository.save(director);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID director_id) {
        directorRepository.deleteById(director_id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
