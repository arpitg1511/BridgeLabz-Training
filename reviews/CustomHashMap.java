public class CustomHashMap {

    
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 10;
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

 
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }


    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public Integer get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

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

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(12, 300);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(12));

        map.remove(2);
        System.out.println(map.get(2));
        System.out.println(map.get(12));
    }
}
