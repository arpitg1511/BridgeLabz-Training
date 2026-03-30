import java.util.*;

public class ReverseQueue {

    static void reverseQueue(Queue<Integer> q) {

        // Base case: empty queue
        if (q.isEmpty()) {
            return;
        }

        // Remove front element
        int front = q.remove();

        // Reverse remaining queue
        reverseQueue(q);

        // Add removed element at the end
        q.add(front);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
