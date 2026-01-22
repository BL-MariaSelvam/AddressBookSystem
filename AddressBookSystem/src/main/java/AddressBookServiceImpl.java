package main.java;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Override
	public void updateContacts(Contacts updatedContact) {
		boolean flag=false;
		for(Contacts oldcontact:contactList) {
		if(oldcontact.getFirstName().equals(updatedContact.getFirstName())){
			oldcontact.setLastName(updatedContact.getLastName());
			oldcontact.setAddress(updatedContact.getAddress());
			oldcontact.setCity(updatedContact.getCity());
			oldcontact.setState(updatedContact.getState());
			oldcontact.setZip(updatedContact.getZip());
			oldcontact.setPhoneNumber(updatedContact.getPhoneNumber());
			oldcontact.setEmail(updatedContact.getEmail());
			flag=true;
			}
		}
		if(flag==true){
			System.out.println("Contact updated");
		}else {
			System.out.println("Contact not found");
		}
	}

	@Override
	public void deleteContacts(String deletedFirstName) {
	    boolean flag = false;
	    Iterator<Contacts> iterator = contactList.iterator();

	    while(iterator.hasNext()) {
	        Contacts contact = iterator.next();
	        if(contact.getFirstName().equals(deletedFirstName)) {
	            iterator.remove(); // safe removal
	            flag = true;
	            break; // remove only the first match, remove break if you want to delete all matches
	        }
	    }

	    if(flag) {
	        System.out.println("Contact deleted");
	    } else {
	        System.out.println("Contact not found");
	    }
	}

		}