package com.wheremystuff.ItemServiceAPI.services;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemTypeDTO;

import java.util.List;

public interface TypeService {
    List<ItemTypeDTO> getTypes();

    ItemTypeDTO getItemFromId(int id);

    void createItem(ItemTypeDTO itemTypeDTO);

    void deleteItem(int id);
}
