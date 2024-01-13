package com.example.lab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.MovieEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class MovieRepository {
    @PersistenceContext
    private EntityManager em;

    public List<MovieEntity> findAll() {
        return em.createQuery("select i from MovieEntity i", MovieEntity.class).getResultList();
    }

    public void persist(MovieEntity entity) {em.persist(entity);}

    public void delete(UUID movie_id){
        MovieEntity entity = em.find(MovieEntity.class, movie_id);
        em.remove(entity);
    }
}
