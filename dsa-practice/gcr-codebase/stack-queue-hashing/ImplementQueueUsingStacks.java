package dsa_practice.gcr_codebase.stacks_queue_hashing;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> stack1; // for enqueue
    private Stack<Integer> stack2; // for dequeue

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // enqueue operation
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " enqueued");
    }

    // dequeue operation
    public int dequeue() {

        // if both stacks empty -> queue empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // move elements only when stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // display queue elements
    public void display() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        // elements in stack2 are already in correct order
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        // elements in stack1 are in reverse order
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }

        System.out.println();
    }

    // main method for testing
    public static void main(String[] args) {

        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        queue.enqueue(40);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
