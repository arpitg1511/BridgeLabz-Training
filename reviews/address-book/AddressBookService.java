import java.util.*;
public class AddressBookService {
	public static void addContact(Contact c) {
		if(!AddressBookData.contactMap.containsKey(c.firstName)) {
			AddressBookData.contactList.add(c);
			AddressBookData.contactMap.put(c.firstName, c);
			System.out.println("Contact added successfully");
		}
		
		else {
			System.out.println("Contact with same Number already exists");
		}
	}
}
