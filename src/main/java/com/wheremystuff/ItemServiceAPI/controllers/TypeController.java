package com.wheremystuff.ItemServiceAPI.controllers;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.dto.models.ItemTypeDTO;
import com.wheremystuff.ItemServiceAPI.models.ItemType;
import com.wheremystuff.ItemServiceAPI.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("api/types")
    public List<ItemTypeDTO> getTypes() {
        return typeService.getTypes();
    }

    @GetMapping("api/types/{id}")
    public ItemTypeDTO getType(@PathVariable int id) {
        return typeService.getItemFromId(id);
    }

    @PostMapping("/api/types")
    public void postItem(@RequestBody ItemTypeDTO itemTypeDTO) {
        typeService.createItem(itemTypeDTO);
    }

    @DeleteMapping("api/types/{id}")
    public void deleteItem(@PathVariable int id) {
        typeService.deleteItem(id);
    }
}
