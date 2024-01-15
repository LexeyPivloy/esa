package com.example.lab4.models;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteMessage extends AuditMessage {

    private Object deletedObject;


    @Override
    public String getInfo() {
        return "Был удален объект %s".formatted(deletedObject);
    }

}
