class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    void display() {
        System.out.println("Item ID   : " + itemId);
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Price     : " + price);
        System.out.println("-------------------------");
    }
}

public class InventoryManagementSystem {

    public static void main(String[] args) {
        ItemNode head = new ItemNode(101, "Laptop", 5, 55000);
        head = addAtBeginning(head, 102, "Mouse", 20, 500);
        addAtLast(head, 103, "Keyboard", 15, 1200);
        head = addAtPosition(head, 104, "Monitor", 7, 15000, 2);

        System.out.println("All Inventory Items:");
        displayAll(head);

        System.out.println("Search by ID 103:");
        ItemNode found = searchById(head, 103);
        if (found != null) found.display();

        System.out.println("Search by Name 'Mouse':");
        ItemNode foundByName = searchByName(head, "Mouse");
        if (foundByName != null) foundByName.display();

        System.out.println("Updating quantity of Item ID 101:");
        updateQuantityById(head, 101, 10);

        System.out.println("Deleting Item ID 102:");
        head = deleteById(head, 102);

        System.out.println("Final Inventory:");
        displayAll(head);

        System.out.println("Total Inventory Value: ₹" + calculateTotalValue(head));

        System.out.println("Sorting Inventory by Item Name:");
        head = sortList(head, "name", true);
        displayAll(head);

        System.out.println("Sorting Inventory by Price Descending:");
        head = sortList(head, "price", false);
        displayAll(head);
    }

    // Add at beginning
    static ItemNode addAtBeginning(ItemNode head, int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        return newNode;
    }

    // Add at end
    static void addAtLast(ItemNode head, int id, String name, int qty, double price) {
        if (head == null) return;
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new ItemNode(id, name, qty, price);
    }

    // Add at position (1-based)
    static ItemNode addAtPosition(ItemNode head, int id, String name, int qty, double price, int position) {
        if (position <= 1 || head == null) return addAtBeginning(head, id, name, qty, price);

        ItemNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) temp = temp.next;

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Delete by Item ID
    static ItemNode deleteById(ItemNode head, int id) {
        if (head == null) return null;
        if (head.itemId == id) return head.next;

        ItemNode temp = head;
        while (temp.next != null) {
            if (temp.next.itemId == id) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
        return head;
    }

    // Search by Item ID
    static ItemNode searchById(ItemNode head, int id) {
        while (head != null) {
            if (head.itemId == id) return head;
            head = head.next;
        }
        return null;
    }

    // Search by Item Name
    static ItemNode searchByName(ItemNode head, String name) {
        while (head != null) {
            if (head.itemName.equalsIgnoreCase(name)) return head;
            head = head.next;
        }
        return null;
    }

    // Update quantity by Item ID
    static void updateQuantityById(ItemNode head, int id, int newQty) {
        while (head != null) {
            if (head.itemId == id) {
                head.quantity = newQty;
                System.out.println("Quantity updated successfully");
                return;
            }
            head = head.next;
        }
        System.out.println("Item not found");
    }

    // Calculate total inventory value
    static double calculateTotalValue(ItemNode head) {
        double total = 0;
        while (head != null) {
            total += head.quantity * head.price;
            head = head.next;
        }
        return total;
    }

    // Display all items
    static void displayAll(ItemNode head) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        while (head != null) {
            head.display();
            head = head.next;
        }
    }

    // Merge Sort Linked List
    static ItemNode sortList(ItemNode head, String key, boolean ascending) {
        if (head == null || head.next == null) return head;

        ItemNode mid = middle(head);
        ItemNode second = mid.next;
        mid.next = null;

        ItemNode left = sortList(head, key, ascending);
        ItemNode right = sortList(second, key, ascending);

        return merge(left, right, key, ascending);
    }

    static ItemNode middle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head;
        ItemNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ItemNode merge(ItemNode l1, ItemNode l2, String key, boolean ascending) {
        ItemNode dummy = new ItemNode(0, "", 0, 0);
        ItemNode current = dummy;

        while (l1 != null && l2 != null) {
            boolean condition = false;

            if (key.equalsIgnoreCase("name")) {
                condition = ascending ? l1.itemName.compareToIgnoreCase(l2.itemName) <= 0
                                      : l1.itemName.compareToIgnoreCase(l2.itemName) > 0;
            } else if (key.equalsIgnoreCase("price")) {
                condition = ascending ? l1.price <= l2.price : l1.price > l2.price;
            }

            if (condition) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
