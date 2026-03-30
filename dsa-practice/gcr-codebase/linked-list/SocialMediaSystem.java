import java.util.*;

class ProfileNode {
    int userId;
    String name;
    int age;
    List<String> friends;
    ProfileNode next;

    ProfileNode(int id, String name, int age, List<String> friends) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friends = friends;
        this.next = null;
    }

    void display() {
        System.out.println(
                "User Id : " + userId +
                "\nName : " + name +
                "\nAge : " + age +
                "\nList of Friends : " + listDisplay()
        );
        System.out.println("---------------------------");
    }

    String listDisplay() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < friends.size(); i++) {
            sb.append(friends.get(i));
            if (i != friends.size() - 1) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}

public class SocialMediaSystem {

    public static void main(String[] args) {

        ProfileNode head = null;

        head = addUser(head, 101, "Arpit", 21);
        head = addUser(head, 102, "Rohit", 22);
        head = addUser(head, 103, "Aman", 23);
        head = addUser(head, 104, "Neha", 20);

        addFriendConnection(head, 101, 102);
        addFriendConnection(head, 101, 103);
        addFriendConnection(head, 102, 103);
        addFriendConnection(head, 103, 104);

        displayFriendsOfUser(head, 101);

        findMutualFriends(head, 101, 103);

        removeFriendConnection(head, 101, 102);

        searchByUserId(head, 103);
        searchByName(head, "Neha");

        countFriends(head);
    }

    // ================= ADD USER =================

    static ProfileNode addUser(ProfileNode head, int id, String name, int age) {
        ProfileNode newNode = new ProfileNode(id, name, age, new ArrayList<>());

        if (head == null) return newNode;

        ProfileNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;

        return head;
    }

    // ================= SEARCH =================

    static ProfileNode getUser(ProfileNode head, int userId) {
        while (head != null) {
            if (head.userId == userId) return head;
            head = head.next;
        }
        return null;
    }

    static void searchByUserId(ProfileNode head, int userId) {
        ProfileNode user = getUser(head, userId);
        if (user != null) user.display();
        else System.out.println("User not found");
    }

    static void searchByName(ProfileNode head, String name) {
        while (head != null) {
            if (head.name.equalsIgnoreCase(name)) {
                head.display();
                return;
            }
            head = head.next;
        }
        System.out.println("User not found");
    }

    // ================= FRIEND OPERATIONS =================

    static void addFriendConnection(ProfileNode head, int id1, int id2) {
        ProfileNode user1 = getUser(head, id1);
        ProfileNode user2 = getUser(head, id2);

        if (user1 == null || user2 == null) {
            System.out.println("Invalid User ID");
            return;
        }

        String u1 = String.valueOf(id1);
        String u2 = String.valueOf(id2);

        if (!user1.friends.contains(u2)) user1.friends.add(u2);
        if (!user2.friends.contains(u1)) user2.friends.add(u1);
    }

    static void removeFriendConnection(ProfileNode head, int id1, int id2) {
        ProfileNode user1 = getUser(head, id1);
        ProfileNode user2 = getUser(head, id2);

        if (user1 == null || user2 == null) return;

        user1.friends.remove(String.valueOf(id2));
        user2.friends.remove(String.valueOf(id1));
    }

    static void displayFriendsOfUser(ProfileNode head, int userId) {
        ProfileNode user = getUser(head, userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println("Friends of " + user.name + " : " + user.listDisplay());
    }

    static void findMutualFriends(ProfileNode head, int id1, int id2) {
        ProfileNode user1 = getUser(head, id1);
        ProfileNode user2 = getUser(head, id2);

        if (user1 == null || user2 == null) {
            System.out.println("Invalid users");
            return;
        }

        System.out.print("Mutual Friends : [ ");
        boolean found = false;

        for (String f : user1.friends) {
            if (user2.friends.contains(f)) {
                System.out.print(f + " ");
                found = true;
            }
        }

        if (!found) System.out.print("None");
        System.out.println("]");
    }

    // ================= COUNT =================

    static void countFriends(ProfileNode head) {
        while (head != null) {
            System.out.println(
                    head.name + " has " + head.friends.size() + " friends"
            );
            head = head.next;
        }
    }
}
