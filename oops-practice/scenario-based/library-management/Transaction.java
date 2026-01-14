package library_management_system;

public class Transaction {

    private Member member;
    private Book book;

    Transaction(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    void display() {
        System.out.println(
            "Member: " + member.getName() +
            " Book: " + book.getTitle()
        );
    }
}

