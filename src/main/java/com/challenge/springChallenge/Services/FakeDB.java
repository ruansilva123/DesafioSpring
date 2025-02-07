package com.challenge.springChallenge.Services;


import com.challenge.springChallenge.Models.SearchData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Service
public class FakeDB {

    private static final String DATABASE_ROOT = "src/fakeDB.json";

    public static void saveDataToFakeDB(SearchData data){
        try{
            Gson gson = new Gson();
            List<SearchData> listData = new ArrayList<>();

            //Verify if the root exists
            File fileRoot = new File(DATABASE_ROOT);
            if(!fileRoot.exists()){
                fileRoot.createNewFile();
            }

            // Verify datas on fake DB
            BufferedReader reader = new BufferedReader(new FileReader(DATABASE_ROOT));
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if(jsonElement.isJsonArray()){
                Type searchDataListType = new TypeToken<ArrayList<SearchData>>() {}.getType();
                listData = gson.fromJson(jsonElement, searchDataListType);
            }

            reader.close();

            // Add new data
            listData.add(data);

            // Write on FakeDB file
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_ROOT));
            gson.toJson(listData, writer);
            writer.close();

            System.out.println("Saved on fake database!");
        }catch (Exception error){
            System.out.println("Error to save in fake database: "+error.toString());
        }
    }
}
