package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookServiceImpl  implements AddressBookService{

	List<Contacts> contactList=new ArrayList<>();
//	Map<String, List<Contacts>> getContactsByCity();
//	Map<String, List<Contacts>> getContactsByState();
	
	@Override
	public void addContact(Contacts contact) {
		 boolean exists = contactList.stream()
		            .anyMatch(c -> c.equals(contact));

		    if (exists) {
		        System.out.println("Duplicate contact! Not added.");
		    } else {
		contactList.add(contact);
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

	@Override
	public void sortContactsByName() {
	    if(contactList.isEmpty()) {
	        System.out.println("No contacts to sort.");
	        return;
	    }

	    // Using Java Streams to sort
	    contactList.stream()
	            .sorted((c1, c2) -> {
	                int cmp = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
	                if(cmp != 0) return cmp;
	                return c1.getLastName().compareToIgnoreCase(c2.getLastName());
	            })
	            .forEach(System.out::println);
	}

	@Override
	public void sortContactsByCity() {
	    if (contactList.isEmpty()) {
	        System.out.println("No contacts to sort.");
	        return;
	    }

	    contactList.stream()
	            .sorted(Comparator.comparing(Contacts::getCity, String.CASE_INSENSITIVE_ORDER))
	            .forEach(System.out::println);
	}

	@Override
	public void sortContactsByState() {
	    if (contactList.isEmpty()) {
	        System.out.println("No contacts to sort.");
	        return;
	    }

	    contactList.stream()
	            .sorted(Comparator.comparing(Contacts::getState, String.CASE_INSENSITIVE_ORDER))
	            .forEach(System.out::println);
	}

	@Override
	public void sortContactsByZip() {
	    if (contactList.isEmpty()) {
	        System.out.println("No contacts to sort.");
	        return;
	    }
	    contactList.stream()
        .sorted(Comparator.comparing(Contacts::getZip)) // assuming ZIP is a String
        .forEach(System.out::println);
}



	@Override
	public void viewContactsByCity(String city) {
	    if(contactList.isEmpty()) {
	        System.out.println("No contacts found.");
	        return;
	    }

	    // Group all contacts by city
	    Map<String, List<Contacts>> cityMap = contactList.stream()
	            .collect(Collectors.groupingBy(c -> c.getCity().toLowerCase()));

	    List<Contacts> contactsInCity = cityMap.get(city.toLowerCase());

	    if(contactsInCity == null || contactsInCity.isEmpty()) {
	        System.out.println("No contacts found in city: " + city);
	    } else {
	        System.out.println("Contacts in city " + city + ":");
	        contactsInCity.forEach(System.out::println);
	    }
	}


	@Override
	public void viewContactsByState(String state) {
	    if(contactList.isEmpty()) {
	        System.out.println("No contacts found.");
	        return;
	    }

	    // Group all contacts by state
	    Map<String, List<Contacts>> stateMap = contactList.stream()
	            .collect(Collectors.groupingBy(c -> c.getState().toLowerCase()));

	    List<Contacts> contactsInState = stateMap.get(state.toLowerCase());

	    if(contactsInState == null || contactsInState.isEmpty()) {
	        System.out.println("No contacts found in state: " + state);
	    } else {
	        System.out.println("Contacts in state " + state + ":");
	        contactsInState.forEach(System.out::println);
	    }
	}

	
	@Override
	public void searchContactsByCity(String city) {
	    if(contactList.isEmpty()) {
	        System.out.println("No contacts available.");
	        return;
	    }

	    // Filter contacts by city (case-insensitive)
	    var results = contactList.stream()
	            .filter(c -> c.getCity().equalsIgnoreCase(city))
	            .toList();  // Java 16+; for earlier versions use collect(Collectors.toList())

	    if(results.isEmpty()) {
	        System.out.println("No contacts found in city: " + city);
	    } else {
	        System.out.println("Contacts in city " + city + ":");
	        results.forEach(System.out::println);
	    }
	}
	@Override
	public void searchContactsByState(String state) {
	    if(contactList.isEmpty()) {
	        System.out.println("No contacts available.");
	        return;
	    }

	    var results = contactList.stream()
	            .filter(c -> c.getState().equalsIgnoreCase(state))
	            .toList();

	    if(results.isEmpty()) {
	        System.out.println("No contacts found in state: " + state);
	    } else {
	        System.out.println("Contacts in state " + state + ":");
	        results.forEach(System.out::println);
	    }
	}

		}