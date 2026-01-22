package main.java;

import java.util.Scanner;

public class AddressBookApp {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		AddressBookService addressBookService=new AddressBookServiceImpl();
		
		do {
			System.out.println("AddressBookSystem");
			System.out.println("1.Add Contacts");
			System.out.println("2.View Contacts");
			System.out.println("3.Edit Contacts");
			System.out.println("4.Delete Contacts");
			System.out.println("5.Sorting by Name");
			System.out.println("6.Exit");
			System.out.println("Enter the option to do");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter the Contact details");
				System.out.println("Enter FirstName");
				String firstName=sc.next();
				System.out.println("Enter LastName");
				String lastName=sc.next();
				System.out.println("Enter Address");
				String address=sc.next();
				System.out.println("Enter City");
				String city=sc.next();
				System.out.println("Enter state");
				String state=sc.next();
				System.out.println("Enter zip");
				String zip=sc.next();
				System.out.println("Enter phoneNumber");
				String phoneNumber=sc.next();
				System.out.println("Enter Email");
				String email=sc.next();
				Contacts contact=new Contacts(firstName,lastName,address,city,state,zip,phoneNumber,email);
				addressBookService.addContact(contact);			
				break;
			case 2:
				addressBookService.displayContacts();
				break;
			case 3:
				System.out.println("Enter the firstName to update contact details");
				String updatedfirstName=sc.next();
				System.out.println("Enter LastName to update");
				String updatedlastName=sc.next();
				System.out.println("Enter Address to update");
				String updatedaddress=sc.next();
				System.out.println("Enter City to update");
				String updatedcity=sc.next();
				System.out.println("Enter state to update");
				String updatedstate=sc.next();
				System.out.println("Enter zip to update");
				String updatedzip=sc.next();
				System.out.println("Enter phoneNumber to update");
				String updatedphoneNumber=sc.next();
				System.out.println("Enter Email to update");
				String updatedemail=sc.next();
				Contacts updatedContact=new Contacts(updatedfirstName,updatedlastName,updatedaddress,updatedcity,updatedstate,updatedzip,updatedphoneNumber,updatedemail);
				addressBookService.updateContacts(updatedContact);
				break;	
			case 4:
				System.out.println("Enter the firstName to delete contact details");
				String deletedfirstName=sc.next();
				addressBookService.deleteContacts(deletedfirstName);
				break;
			case 5:
				addressBookService.sortContactsByName();
				break;
			case 6:
				System.out.println("Returning to home");
				break;
			default:
				System.out.println("No option found");
				break;
			}
		}while(true);
		
	}

}
