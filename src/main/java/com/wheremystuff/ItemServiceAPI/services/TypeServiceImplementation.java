package com.wheremystuff.ItemServiceAPI.services;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.dto.models.ItemTypeDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;
import com.wheremystuff.ItemServiceAPI.models.ItemType;
import com.wheremystuff.ItemServiceAPI.repository.TypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeServiceImplementation implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemTypeDTO> getTypes() {
        return typeRepository.findAll()
                .stream()
                .map(type -> modelMapper.map(type, ItemTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemTypeDTO getItemFromId(int id) {
        ItemType type = typeRepository.findOne(id);
        if (type == null) {
            return null;
        }
        return modelMapper.map(typeRepository.findOne(id), ItemTypeDTO.class);
    }

    @Override
    public void createItem(ItemTypeDTO itemTypeDTO) {
        typeRepository.createItem(itemTypeDTO);
    }

    @Override
    public void deleteItem(int id) {
        typeRepository.deleteItem(id);
    }
}
