package roundabout_flow;

class VehicleQueue {

    private String[] queue;
    private int front = 0;
    private int rear = -1;
    private int size = 0;
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
    }

    void enqueue(String vehicle) {

        if (size == capacity) {
            System.out.println("Queue Overflow! Cannot add " + vehicle);
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = vehicle;
        size++;

        System.out.println(vehicle + " waiting to enter");
    }

    String dequeue() {

        if (size == 0) {
            System.out.println("Queue Underflow! No vehicles waiting");
            return null;
        }

        String vehicle = queue[front];
        front = (front + 1) % capacity;
        size--;

        return vehicle;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

