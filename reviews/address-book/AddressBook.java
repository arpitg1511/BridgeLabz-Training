
public class AddressBook {
	public static void main(String[] args) {
		Contact c1 = new Contact("Arpit", "Gupta", "Firozabad", "Firozabad", "283203", "7505XXXXXX", "xyz@gmail.com");
		
		AddressBookService.addContact(c1);
		AddressBookService.addContact(c1);
	}
}
