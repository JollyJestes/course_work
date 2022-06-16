package com.example.demo4.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Database {
    private List<Warehouse> database;

    public Database() {
        database = new ArrayList<Warehouse>();
    }


    public static String getStringDatabase() throws IOException {
        Path file = Paths.get("./warehouses-db.json");
        List<String> lines = Files.readAllLines(file);
        String json = "";
        for (int i = 0; i < lines.size(); i++) {
            json += lines.get(i);
        }
        return json;
    }


    public boolean add(Warehouse contributor) {
        return database.add(contributor);
    }


    public boolean remove(int index) {
        Warehouse contributor = database.get(index);
        return database.remove(contributor);
    }


    public Warehouse getContributor(int index) {
        return database.get(index);
    }


    public List<Warehouse> getDatabase() {
        return database;
    }


    public void load() {
        this.clear();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("./warehouses-db.json"));
            this.database = new Gson().fromJson(reader, new TypeToken<List<Warehouse>>() {
            }.getType());
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public String databaseObjectToJsonString(int index) {
        Gson gson = new Gson();
        return gson.toJson(database.get(index));
    }


    public void save() {
        Gson gson = new GsonBuilder().create();
        JsonArray json = gson.toJsonTree(database).getAsJsonArray();
        try (FileWriter writer = new FileWriter("./warehouses-db.json", false)) {
            writer.write(json.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private void clear() {
        this.database.clear();
    }

    public String getMoreThan50() {
        Database min = new Database();
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getMinimum_batch() > 50) {
                min.add(database.get(i));
            }
        }

        Gson gson = new Gson();
        return gson.toJson(min);
    }

    public String getMoreMonth() {
        Database max = new Database();
        for (int i = 0; i < database.size(); i++) {
            if ((((Calendar.getInstance().get(Calendar.DAY_OF_YEAR)) - (database.get(i).getDate().get(Calendar.DAY_OF_YEAR)))
                    > 31) && Calendar.getInstance().get(Calendar.YEAR) == database.get(i).getDate().get(Calendar.YEAR)) {
                max.add(database.get(i));
            }
            if ((Calendar.getInstance().get(Calendar.YEAR) - 1) == (database.get(i).getDate().get(Calendar.YEAR))
                    && database.get(i).getDate().get(Calendar.DAY_OF_YEAR) > 336) {
                max.add(database.get(i));
            }
            if((Calendar.getInstance().get(Calendar.YEAR) -2 >= (database.get(i).getDate().get(Calendar.YEAR)) )){
                max.add(database.get(i));
            }
        }

        Gson gson = new Gson();
        return gson.toJson(max);
    }
}
