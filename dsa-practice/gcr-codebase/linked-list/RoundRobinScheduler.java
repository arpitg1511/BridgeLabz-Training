class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime;
    int turnaroundTime;

    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }

    void display() {
        System.out.println(
                "PID: " + processId +
                " | Burst: " + burstTime +
                " | Remaining: " + remainingTime +
                " | Priority: " + priority
        );
    }
}

public class RoundRobinScheduler {

    // ================= ADD PROCESS =================
    static ProcessNode addAtEnd(ProcessNode head, int pid, int burst, int priority) {

        ProcessNode newNode = new ProcessNode(pid, burst, priority);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
        return head;
    }

    // ================= REMOVE PROCESS =================
    static ProcessNode removeByProcessId(ProcessNode head, int pid) {

        if (head == null)
            return null;

        // Single node
        if (head.next == head && head.processId == pid)
            return null;

        // Removing head
        if (head.processId == pid) {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = head.next;
            return head.next;
        }

        ProcessNode temp = head;
        while (temp.next != head && temp.next.processId != pid)
            temp = temp.next;

        if (temp.next.processId == pid)
            temp.next = temp.next.next;

        return head;
    }

    // ================= ROUND ROBIN SCHEDULING =================
    static void roundRobin(ProcessNode head, int timeQuantum) {

        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        int time = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;
        int completed = 0;

        ProcessNode current = head;

        System.out.println("\n--- Round Robin Execution ---");

        while (head != null) {

            current.display();

            if (current.remainingTime > timeQuantum) {
                time += timeQuantum;
                current.remainingTime -= timeQuantum;
            } else {
                time += current.remainingTime;
                current.remainingTime = 0;

                current.turnaroundTime = time;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                totalWaiting += current.waitingTime;
                totalTurnaround += current.turnaroundTime;
                completed++;

                int pid = current.processId;
                current = current.next;
                head = removeByProcessId(head, pid);

                displayQueue(head);
                continue;
            }

            current = current.next;
            displayQueue(head);
        }

        System.out.println("\n--- Scheduling Complete ---");
        System.out.println("Average Waiting Time: " +
                (double) totalWaiting / completed);
        System.out.println("Average Turnaround Time: " +
                (double) totalTurnaround / completed);
    }

    // ================= DISPLAY QUEUE =================
    static void displayQueue(ProcessNode head) {

        if (head == null) {
            System.out.println("Queue Empty\n");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Current Queue:");
        do {
            temp.display();
            temp = temp.next;
        } while (temp != head);

        System.out.println("---------------------------");
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        ProcessNode head = null;

        head = addAtEnd(head, 1, 5, 2);
        head = addAtEnd(head, 2, 3, 1);
        head = addAtEnd(head, 3, 8, 3);
        head = addAtEnd(head, 4, 6, 2);

        int timeQuantum = 2;

        displayQueue(head);
        roundRobin(head, timeQuantum);
    }
}
