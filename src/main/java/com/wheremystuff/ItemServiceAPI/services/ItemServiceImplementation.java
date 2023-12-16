package com.wheremystuff.ItemServiceAPI.services;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;
import com.wheremystuff.ItemServiceAPI.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImplementation implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemFromId(int id) {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            return null;
        }
        return modelMapper.map(itemRepository.findOne(id), ItemDTO.class);
        /* return itemRepository.findOne(id); */
    }

    @Override
    public void createItem(ItemDTO itemDTO) {
        itemRepository.createItem(itemDTO);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteItem(id);
    }
}
