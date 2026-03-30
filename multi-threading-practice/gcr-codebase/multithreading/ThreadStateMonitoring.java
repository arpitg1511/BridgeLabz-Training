import java.text.SimpleDateFormat;
import java.util.Date;

class TaskRunner implements Runnable {

    @Override
    public void run() {
        // RUNNABLE (computation)
        for (int i = 0; i < 1000000; i++) {
            int x = i * i;
        }

        // TIMED_WAITING
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }
    }
}

class StateMonitor implements Runnable {

    private Thread[] threads;

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    private String time() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    @Override
    public void run() {

        boolean monitoring = true;

        while (monitoring) {
            monitoring = false;

            for (Thread t : threads) {
                System.out.println("[Monitor] " + t.getName()
                        + " is in " + t.getState()
                        + " state at " + time());

                if (t.getState() != Thread.State.TERMINATED) {
                    monitoring = true;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }

        System.out.println("Summary:");
        for (Thread t : threads) {
            System.out.println(t.getName() + " went through multiple states and is now TERMINATED");
        }
    }
}

public class ThreadStateMonitoring {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner task = new TaskRunner();

        Thread task1 = new Thread(task, "Task-1");
        Thread task2 = new Thread(task, "Task-2");

        Thread[] tasks = { task1, task2 };

        // NEW state (before start)
        Thread monitor = new Thread(new StateMonitor(tasks), "State-Monitor");

        monitor.start();

        Thread.sleep(500); // ensure NEW state is observed

        task1.start();
        task2.start();

        task1.join();
        task2.join();
        monitor.join();
    }
}
