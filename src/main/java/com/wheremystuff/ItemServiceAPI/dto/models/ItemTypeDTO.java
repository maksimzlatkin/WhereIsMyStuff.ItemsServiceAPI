package com.wheremystuff.ItemServiceAPI.dto.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ItemTypeDTO {
    private int id;
    private String name;
    private String description;

    public ItemTypeDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
