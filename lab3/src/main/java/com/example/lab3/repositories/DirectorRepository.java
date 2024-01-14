package com.example.lab3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab3.models.DirectorEntity;

import java.util.UUID;

public interface DirectorRepository extends JpaRepository<DirectorEntity, UUID> {

}
