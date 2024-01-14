package com.example.lab3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "directors")
public class DirectorEntity {
    @Id
    @Column(name = "director_id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

}
