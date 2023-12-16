package com.wheremystuff.ItemServiceAPI.repository;

import com.wheremystuff.ItemServiceAPI.dto.models.ItemDTO;
import com.wheremystuff.ItemServiceAPI.dto.models.ItemTypeDTO;
import com.wheremystuff.ItemServiceAPI.models.Item;
import com.wheremystuff.ItemServiceAPI.models.ItemType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeRepositoryImplementation implements TypeRepository {

    public List<ItemType> findAll() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/types.json"));

            List<ItemType> types = new ArrayList<ItemType>();

            for (Object o : arr) {
                JSONObject i = (JSONObject) o;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                types.add(new ItemType(Math.toIntExact((long) i.get("id")), (String) i.get("name"), (String) i.get("description")));
            }
            return types;
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

    public ItemType findOne(int id) {
        List<ItemType> types = findAll();

        for (ItemType type: types) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }

    @Override
    public void createItem(ItemTypeDTO itemTypeDTO) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/types.json"));

            JSONObject newItem = new JSONObject();
            newItem.put("id", itemTypeDTO.getDescription());
            newItem.put("name", itemTypeDTO.getName());
            newItem.put("description", itemTypeDTO.getDescription());

            arr.add(newItem);
            FileWriter file = new FileWriter("./src/main/resources/static/types.json");
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
            JSONArray arr = (JSONArray) parser.parse(new FileReader("./src/main/resources/static/types.json"));

            for (Object o : arr) {
                JSONObject i = (JSONObject) o;
                if (Math.toIntExact((Long)i.get("id")) == id) {
                    arr.remove(o);
                    break;
                }
            }

            FileWriter file = new FileWriter("./src/main/resources/static/types.json");
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
