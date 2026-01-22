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
			System.out.println("3.Exit");
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
				System.out.println("Returning to home");
				break;
			default:
				System.out.println("No option found");
				break;
			}
		}while(true);
		
	}

}
