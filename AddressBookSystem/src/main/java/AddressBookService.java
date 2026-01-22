package main.java;

public interface AddressBookService {

	void addContact(Contacts contact);

	void displayContacts();

	void updateContacts(Contacts updatedContact);

	void deleteContacts(String deletedfirstName);

	void sortContactsByName();

	void sortContactsByCity();

	void sortContactsByState();

	void sortContactsByZip();

	void viewContactsByCity(String city1);

	void viewContactsByState(String state1);

	void searchContactsByCity(String citySearch);

	void searchContactsByState(String stateSearch);

}
