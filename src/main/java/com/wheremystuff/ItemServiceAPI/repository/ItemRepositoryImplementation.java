package com.wheremystuff.ItemServiceAPI.repository;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepositoryImplementation implements ItemRepository {

    public List<Item> findAll() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/items.json"));

            List<Item> items = new ArrayList<Item>();

            for (Object o : arr) {
                JSONObject i = (JSONObject) o;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                items.add(new Item(Math.toIntExact((long) i.get("id")), (String) i.get("name"), (String) i.get("type"), (String) i.get("description"),
                        LocalDateTime.parse((String) i.get("created_date"), formatter), (String) i.get("name")));
            }
            return items;
        }
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
        catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
        catch (ParseException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Item findOne(int id) {
        List<Item> items = findAll();
//        for (int i = 0; i < items.size(); i++){
//            if (items.get(i).getId() == id) {
//                return items.get(i);
//            }
//        }

        for (Item item: items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    @Override
    public void createItem(ItemDTO itemDTO) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/items.json"));

            JSONObject newItem = new JSONObject();
            newItem.put("id", itemDTO.getId());
            newItem.put("name", itemDTO.getName());
            newItem.put("type", itemDTO.getType());
            newItem.put("description", itemDTO.getDescription());
            newItem.put("created_date", itemDTO.getCreated_date());
            newItem.put("color", itemDTO.getColor());

            arr.add(newItem);
            FileWriter file = new FileWriter("./src/main/resources/static/items.json");
            file.write(arr.toJSONString());
            file.flush();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        catch (ParseException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void deleteItem(int id) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/items.json"));

            for (Object o : arr) {
                JSONObject i = (JSONObject) o;
                if (Math.toIntExact((Long)i.get("id")) == id) {
                    arr.remove(o);
                    break;
                }
            }

            FileWriter file = new FileWriter("./src/main/resources/static/items.json");
            file.write(arr.toJSONString());
            file.flush();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        catch (ParseException e) {
            System.out.println(e.toString());
        }
    }
}
