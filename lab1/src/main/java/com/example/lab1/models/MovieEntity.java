package com.example.lab1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class MovieEntity {
    @Id
    @Column(name = "movie_id")
    private UUID id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "director_id")
    private UUID director_id;

}
