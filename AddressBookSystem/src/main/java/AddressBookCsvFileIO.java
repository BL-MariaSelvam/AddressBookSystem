package main.java;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBookCsvFileIO {

    private static final String FILE_PATH = "C:\\Users\\maria\\Desktop\\Selva\\filehandling\\AddressBook.csv";

    // Write Contacts to CSV
    public static void writeData(List<Contacts> contactList) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH))) {

            // Header
            String[] header = {
                "FirstName", "LastName", "Address", "City",
                "State", "Zip", "Phone", "Email"
            };
            writer.writeNext(header);

            // Data
            for (Contacts c : contactList) {
                String[] row = {
                    c.getFirstName(),
                    c.getLastName(),
                    c.getAddress(),
                    c.getCity(),
                    c.getState(),
                    c.getZip(),
                    c.getPhoneNumber(),
                    c.getEmail()
                };
                writer.writeNext(row);
            }

            System.out.println("Address Book written to CSV file");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read Contacts from CSV
    public static List<Contacts> readData() {
        List<Contacts> contactList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {

            String[] record;
            boolean skipHeader = true;

            while ((record = reader.readNext()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                Contacts contact = new Contacts(
                        record[0], record[1], record[2],
                        record[3], record[4], record[5],
                        record[6], record[7]
                );
                contactList.add(contact);
            }

            System.out.println("Address Book read from CSV file");

        } catch (Exception e) {
            System.out.println("CSV file not found");
        }
        return contactList;
    }
}

