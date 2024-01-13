package com.example.lab2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab2.models.DirectorEntity;

import java.util.List;
import java.util.UUID;

public interface DirectorRepository extends JpaRepository<DirectorEntity, UUID> {

}
