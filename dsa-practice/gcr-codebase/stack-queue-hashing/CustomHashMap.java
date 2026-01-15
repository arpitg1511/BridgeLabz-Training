public class CustomHashMap {

    // Node for Linked List
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 10; // bucket size
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    // Hash function
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // PUT operation
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // check if key already exists
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // update
                return;
            }
            curr = curr.next;
        }

        // insert at beginning
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // GET operation
    public Integer get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null; // not found
    }

    // REMOVE operation
    public boolean remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(12, 300); // collision with key 2

        System.out.println(map.get(1));   // 100
        System.out.println(map.get(2));   // 200
        System.out.println(map.get(12));  // 300

        map.remove(2);
        System.out.println(map.get(2));   // null
    }
}
