import java.util.*;

class Node {
    int rollNo;
    String name;
    int age;
    char grade;
    Node next;

    Node(int roll, String name, int age, char grade) {
        this.rollNo = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Grade   : " + grade);
        System.out.println("---------------------");
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initial student
        Node head = new Node(101, "Arpit", 21, 'A');

        head = addAtBeginning(head, 102, "Ravi", 20, 'B');
        addAtLast(head, 103, "Neha", 22, 'A');
        head = addAtPosition(head, 104, "Aman", 23, 'C', 2);

        System.out.println("All Students:");
        displayAll(head);

        System.out.println("Searching Roll 103:");
        Node found = searchByRollNo(head, 103);
        if (found != null) found.display();
        else System.out.println("Student not found");

        System.out.println("Updating grade of Roll 101:");
        updateByRollNo(head, 101, 'A');

        System.out.println("Deleting Roll 102:");
        head = deleteByRollNo(head, 102);

        System.out.println("Final List:");
        displayAll(head);

        sc.close();
    }

    // Add at beginning
    static Node addAtBeginning(Node head, int roll, String name, int age, char grade) {
        Node newNode = new Node(roll, name, age, grade);
        newNode.next = head;
        return newNode;
    }

    // Add at end
    static void addAtLast(Node head, int roll, String name, int age, char grade) {
        Node newNode = new Node(roll, name, age, grade);

        if (head == null) return;

        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    // Add at position (1-based)
    static Node addAtPosition(Node head, int roll, String name, int age, char grade, int position) {

        if (position <= 1) {
            return addAtBeginning(head, roll, name, age, grade);
        }

        Node newNode = new Node(roll, name, age, grade);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Delete by roll number
    static Node deleteByRollNo(Node head, int roll) {

        if (head == null) return null;

        if (head.rollNo == roll) {
            return head.next;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.rollNo == roll) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
        return head;
    }

    // Search
    static Node searchByRollNo(Node head, int roll) {
        while (head != null) {
            if (head.rollNo == roll) return head;
            head = head.next;
        }
        return null;
    }

    // Update grade
    static void updateByRollNo(Node head, int roll, char grade) {
        while (head != null) {
            if (head.rollNo == roll) {
                head.grade = grade;
                System.out.println("Grade updated");
                return;
            }
            head = head.next;
        }
        System.out.println("Student not found");
    }

    // Display
    static void displayAll(Node head) {
        if (head == null) {
            System.out.println("No records found");
            return;
        }

        while (head != null) {
            head.display();
            head = head.next;
        }
    }
}
