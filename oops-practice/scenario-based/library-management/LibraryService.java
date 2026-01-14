package library_management_system;

import java.util.*;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void registerMember(Member member) {
        members.add(member);
    }

    void issueBook(Member member, Book book)
            throws BookNotAvailableException {

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book already issued");
        }

        book.issue();
        transactions.add(new Transaction(member, book));
        System.out.println("Book issued successfully");
    }

    void returnBook(Book book) {
        book.returned();
        System.out.println("Book returned");
    }

    void showTransactions() {
        for (Transaction t : transactions) {
            t.display();
        }
    }
}

