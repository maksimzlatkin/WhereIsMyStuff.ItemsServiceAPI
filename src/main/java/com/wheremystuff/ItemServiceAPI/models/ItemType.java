package com.wheremystuff.ItemServiceAPI.models;

import lombok.Data;

@Data
public class Type {
    private int id;
    private String name;
    private String description;

    public Type(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
