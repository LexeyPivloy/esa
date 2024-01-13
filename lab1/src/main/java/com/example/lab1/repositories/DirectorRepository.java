package com.example.lab1.repositories;
import com.example.lab1.models.DirectorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;

import java.util.List;
import java.util.UUID;

@Stateless
public class DirectorRepository {

    @PersistenceContext
    private  EntityManager em;

    public  List<DirectorEntity> findAll(){
        return em.createQuery("select i from DirectorEntity i", DirectorEntity.class).getResultList();
    }

    public void persist(DirectorEntity entity) {em.persist(entity);}

    public void delete(UUID director_id){
        DirectorEntity entity = em.find(DirectorEntity.class, director_id);
        em.remove(entity);
    }

}
