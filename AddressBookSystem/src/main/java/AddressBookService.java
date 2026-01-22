package main.java;

public interface AddressBookService {

	void addContact(Contacts contact);

	void displayContacts();

	void updateContacts(Contacts updatedContact);

	void deleteContacts(String deletedfirstName);

}
