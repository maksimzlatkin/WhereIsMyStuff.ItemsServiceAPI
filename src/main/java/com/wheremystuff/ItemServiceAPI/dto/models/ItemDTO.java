package com.wheremystuff.ItemServiceAPI.dto.models;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private int id;
    private String name;
    private String type;
    private String description;
    private String created_date;
    private String color;
}
