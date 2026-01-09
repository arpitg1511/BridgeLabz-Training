class TaskNode {
    String taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(String taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    void display() {
        System.out.println("Task Id : " + taskId +
                "\nTask Name : " + taskName +
                "\nPriority : " + priority +
                "\nDue Date : " + dueDate +
                "\n-------------------------");
    }
}

public class TaskScheduler {

    public static void main(String[] args) {

        // Create first task
        TaskNode head = new TaskNode("T001", "Car Buying", 2, "19/12/2026");
        head.next = head;

        // Add tasks
        head = addAtBeginning(head, "T000", "Grow Up", 1, "10/12/2003");
        head = addAtLast(head, "T002", "Job Preparation", 1, "01/07/2025");
        head = addAtPosition(head, "T003", "Travel Planning", 3, "15/08/2025", 2);

        // Display all tasks
        displayAll(head);

        // View current task and move to next
        head = viewCurrentAndMoveNext(head);
        head = viewCurrentAndMoveNext(head);

        // Search by priority
        searchByPriority(head, 1);

        // Remove a task
        head = removeByTaskId(head, "T002");
        displayAll(head);
    }

    // ================= ADD METHODS =================

    static TaskNode addAtBeginning(TaskNode head, String taskId, String taskName,
                                   int priority, String dueDate) {

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = head;
        while (head.next != newNode.next) {
            head = head.next;
        }
        head.next = newNode;
        return newNode;
    }

    static TaskNode addAtLast(TaskNode head, String taskId, String taskName,
                              int priority, String dueDate) {

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
        return head;
    }

    static TaskNode addAtPosition(TaskNode head, String taskId, String taskName,
                                  int priority, String dueDate, int position) {

        if (head == null || position <= 0)
            return addAtBeginning(head, taskId, taskName, priority, dueDate);

        TaskNode temp = head;
        int pos = 1;

        while (temp.next != head && pos <= position - 1) {
            temp = temp.next;
            pos++;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (temp.next == head) {
            temp.next = newNode;
            newNode.next = head;
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // ================= REMOVE =================

    static TaskNode removeByTaskId(TaskNode head, String taskId) {

        if (head == null) {
            System.out.println("List is Empty");
            return null;
        }

        if (head.next == head && head.taskId.equalsIgnoreCase(taskId)) {
            return null;
        }

        if (head.taskId.equalsIgnoreCase(taskId)) {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            return head.next;
        }

        TaskNode temp = head;
        while (temp.next != head &&
                !temp.next.taskId.equalsIgnoreCase(taskId)) {
            temp = temp.next;
        }

        if (temp.next.taskId.equalsIgnoreCase(taskId)) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Task not found");
        }

        return head;
    }

    // ================= VIEW CURRENT & MOVE =================

    static TaskNode viewCurrentAndMoveNext(TaskNode head) {
        if (head == null) {
            System.out.println("No tasks available");
            return null;
        }

        System.out.println("Current Task:");
        head.display();

        return head.next;
    }

    // ================= SEARCH =================

    static void searchByPriority(TaskNode head, int priority) {

        if (head == null) return;

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                temp.display();
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }

    // ================= DISPLAY =================

    static void displayAll(TaskNode head) {

        if (head == null) return;

        TaskNode temp = head;
        do {
            temp.display();
            temp = temp.next;
        } while (temp != head);

        System.out.println("==================================");
    }
}
