package library_management_system;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();

        Book b1 = new Book(1, "Java Basics");
        Book b2 = new Book(2, "OOP Concepts");

        Member m1 = new Member(101, "Aman");

        library.addBook(b1);
        library.addBook(b2);
        library.registerMember(m1);

        FineCalculator studentFine = new StudentFine();
        FineCalculator staffFine = new StaffFine();

        try {
            library.issueBook(m1, b1);
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        library.returnBook(b1);

        System.out.println("Student fine " +
                studentFine.calculateFine(3));

        System.out.println("Staff fine " +
                staffFine.calculateFine(3));

        library.showTransactions();
    }
}

