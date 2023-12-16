package com.wheremystuff.ItemServiceAPI.dto.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TypeDTO {
    private int id;
    private String name;
    private String description;

    public TypeDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
