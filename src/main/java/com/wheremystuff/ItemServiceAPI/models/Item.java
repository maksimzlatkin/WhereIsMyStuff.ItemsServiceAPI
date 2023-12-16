package com.wheremystuff.ItemServiceAPI.models;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Item {
    private int id;
    private String name;
    private String type;
    private String description;
    private String location;
    private LocalDateTime createdDate;
    private String color;

    public Item(int id, String name, String type, String description, LocalDateTime createdDate, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.createdDate = createdDate;
        this.color = color;
    }

    public Item(int id, String name, String type, String description, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Item(ItemDTO itemDTO) {
        this.id = itemDTO.getId();
        this.name = itemDTO.getName();
        this.type = itemDTO.getType();
        this.description = itemDTO.getDescription();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        this.createdDate = LocalDateTime.parse(itemDTO.getCreated_date(), formatter);
        this.color = itemDTO.getColor();
    }
}
