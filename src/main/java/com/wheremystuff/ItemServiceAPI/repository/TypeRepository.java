package com.wheremystuff.ItemServiceAPI.repository;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.dto.models.ItemTypeDTO;
import com.wheremystuff.ItemServiceAPI.models.ItemType;

import java.util.List;

public interface TypeRepository {

    List<ItemType> findAll();

    ItemType findOne(int id);

    void createItem(ItemTypeDTO itemTypeDTO);

    void deleteItem(int id);
}
