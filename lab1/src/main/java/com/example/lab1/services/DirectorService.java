package com.example.lab1.services;
import com.example.lab1.models.DirectorEntity;
import com.example.lab1.models.dto.DirectorRequest;
import com.example.lab1.repositories.DirectorRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class DirectorService {

    @Inject
    private DirectorRepository directorRepository;

    public List<DirectorEntity> getAll() {return directorRepository.findAll();}

    public UUID create(DirectorRequest directorRequest){
        DirectorEntity director = new DirectorEntity(randomUUID(), directorRequest.getName());
        directorRepository.persist(director);
        return director.getId();
    }

    public void delete(UUID director_id) {
        directorRepository.delete(director_id);
    }
}
