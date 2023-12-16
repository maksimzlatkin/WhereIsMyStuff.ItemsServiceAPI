package com.wheremystuff.ItemServiceAPI.services;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItems();

    ItemDTO getItemFromId(int id);

    void createItem(ItemDTO itemDTO);

    void deleteItem(int id);
}
