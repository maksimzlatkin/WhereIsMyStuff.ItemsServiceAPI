package com.wheremystuff.ItemServiceAPI.controllers;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;
import com.wheremystuff.ItemServiceAPI.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/items")
    public List<ItemDTO> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/api/items/{id}")
    public ItemDTO getItem(@PathVariable int id) {
        ItemDTO item = itemService.getItemFromId(id);
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }
        return item;
    }

    @PostMapping("/api/items")
    public void postItem(@RequestBody ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
    }

    @DeleteMapping("api/items/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}
