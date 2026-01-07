import java.util.*;

// custom exception for invalid phone number
class InvalidPhoneNumberException extends Exception {

    InvalidPhoneNumberException(String message) {
        super(message);
    }
}

// contact class
class Contact {

    private String name;
    private String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }
}

// contact organizer class
class ContactOrganizer {

    private List<Contact> contacts = new ArrayList<>();

    // add contact
    void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {

        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully");
    }

    // delete contact by phone number
    void deleteContact(String phoneNumber) {

        Iterator<Contact> it = contacts.iterator();

        while (it.hasNext()) {
            Contact c = it.next();
            if (c.getPhoneNumber().equals(phoneNumber)) {
                it.remove();
                System.out.println("Contact deleted successfully");
                return;
            }
        }

        System.out.println("Contact not found");
    }

    // search contact
    void searchContact(String phoneNumber) {

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Name : " + c.getName());
                System.out.println("Phone: " + c.getPhoneNumber());
                return;
            }
        }

        System.out.println("Contact not found");
    }
}

// main class
public class PhoneContacts {

    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Arpit", "9876543210");
            organizer.addContact("Rahul", "9876543210"); // duplicate
            organizer.addContact("Neha", "12345");       // invalid
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        organizer.searchContact("9876543210");
        organizer.deleteContact("9876543210");
        organizer.searchContact("9876543210");
    }
}
