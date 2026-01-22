package main.java;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AddressBookJsonFileIO {

    private static final String FILE_PATH = "C:\\Users\\maria\\Desktop\\Selva\\filehandling\\AddressBook.json";

    // Write contacts to JSON
    public static void writeData(List<Contacts> contactList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(contactList, writer);
            System.out.println("Address Book written to JSON file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read contacts from JSON
    public static List<Contacts> readData() {
        Gson gson = new Gson();
        Type contactListType = new TypeToken<List<Contacts>>() {}.getType();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, contactListType);
        } catch (Exception e) {
            System.out.println("No existing JSON file found.");
        }
        return null;
    }
}

