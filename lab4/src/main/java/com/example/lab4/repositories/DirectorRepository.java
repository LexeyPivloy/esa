package com.example.lab4.repositories;

import com.example.lab4.models.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectorRepository extends JpaRepository<DirectorEntity, UUID> {

}
