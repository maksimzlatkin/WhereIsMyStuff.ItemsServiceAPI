package com.wheremystuff.ItemServiceAPI.repository;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findAll();
    Item findOne(int id);

    void createItem(ItemDTO itemDTO);

    void deleteItem(int id);
}
