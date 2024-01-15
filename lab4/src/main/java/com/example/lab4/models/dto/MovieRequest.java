package com.example.lab4.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MovieRequest {
    private String title;
    private UUID director_id;
}
