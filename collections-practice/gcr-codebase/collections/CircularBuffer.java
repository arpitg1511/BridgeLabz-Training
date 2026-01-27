public class CircularBuffer {

    int[] buffer;
    int size;
    int front = 0;
    int rear = 0;
    int count = 0;

    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert element
    void insert(int value) {

        // If buffer is full, overwrite oldest
        if (count == size) {
            front = (front + 1) % size;  // remove oldest
            count--;
        }

        buffer[rear] = value;
        rear = (rear + 1) % size;
        count++;
    }

    // Display buffer
    void display() {
        System.out.print("Buffer: ");

        int index = front;

        for (int i = 0; i < count; i++) {
            System.out.print(buffer[index] + " ");
            index = (index + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();   // 1 2 3

        cb.insert(4);   // overwrites 1
        cb.display();   // 2 3 4
    }
}
