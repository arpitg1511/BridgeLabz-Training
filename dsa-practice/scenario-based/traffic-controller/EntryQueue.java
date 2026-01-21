class EntryQueue {
    private int[] waitingCars;
    private int front = 0, rear = -1, count = 0;

    public EntryQueue(int capacity) {
        waitingCars = new int[capacity];
    }

    public void addToQueue(int carNumber) {
        if (count == waitingCars.length) {
            System.out.println("Waiting area full. Car " + carNumber + " denied entry.");
            return;
        }
        rear = (rear + 1) % waitingCars.length;
        waitingCars[rear] = carNumber;
        count++;
    }

    public Integer allowEntry() {
        if (count == 0) {
            System.out.println("No cars waiting for entry.");
            return null;
        }
        int car = waitingCars[front];
        front = (front + 1) % waitingCars.length;
        count--;
        return car;
    }

    public boolean hasWaitingCars() {
        return count > 0;
    }
}
