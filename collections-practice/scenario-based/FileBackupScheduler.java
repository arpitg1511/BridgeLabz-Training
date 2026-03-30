import java.util.*;

// Custom Exception
class InvalidBackupPathException extends Exception {
    InvalidBackupPathException(String msg) {
        super(msg);
    }
}

// Backup Task class
class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority;   // higher number = higher priority

    BackupTask(String folderPath, int priority) {
        this.folderPath = folderPath;
        this.priority = priority;
    }

    // PriorityQueue sorting logic
    public int compareTo(BackupTask other) {
        return other.priority - this.priority; // descending order
    }

    public String toString() {
        return folderPath + " (Priority " + priority + ")";
    }
}

// Scheduler class
class BackupScheduler {
    PriorityQueue<BackupTask> pq = new PriorityQueue<>();

    void addTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path");
        }
        pq.add(new BackupTask(path, priority));
    }

    void executeTasks() {
        System.out.println("Executing backup tasks:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Main class
public class FileBackupScheduler {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BackupScheduler scheduler = new BackupScheduler();

        try {
            System.out.print("Enter number of backup tasks: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter folder path: ");
                String path = sc.nextLine();

                System.out.print("Enter priority: ");
                int priority = sc.nextInt();
                sc.nextLine();

                scheduler.addTask(path, priority);
            }

            scheduler.executeTasks();

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
