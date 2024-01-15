package com.example.lab4.repositories;

import com.example.lab4.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieEntity, UUID> {

}
