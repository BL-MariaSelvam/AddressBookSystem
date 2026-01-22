package main.java;

import java.util.ArrayList;
import java.util.List;

public class AddressBookServiceImpl  implements AddressBookService{

	List<Contacts> contactList=new ArrayList<>();
	
	@Override
	public void addContact(Contacts contact) {
		
		contactList.add(contact);
		if(!contactList.isEmpty()) {
			System.out.println("Contact Added Successfully and the List size will be "+contactList.size());
		}
	}

	@Override
	public void displayContacts() {
		
		if(contactList.isEmpty()) {
			System.out.println("No record Found");
		}
		else {
			for(Contacts contact:contactList) {
				System.out.println(contact.toString());
			}
		}
	}
}
