class Chef implements Runnable {

    private String chefName;
    private String dish;
    private int totalTime; // in milliseconds

    public Chef(String chefName, String dish, int totalTime) {
        this.chefName = chefName;
        this.dish = dish;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {

        System.out.println(chefName + " started preparing " + dish);

        int[] progressSteps = {25, 50, 75, 100};
        int stepTime = totalTime / progressSteps.length;

        for (int progress : progressSteps) {
            try {
                Thread.sleep(stepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(chefName + " preparing " + dish + ": " + progress + "% complete");
        }

        System.out.println(chefName + " finished preparing " + dish);
    }
}

public class RestaurantOrderProcessing {

    public static void main(String[] args) throws InterruptedException {

        Thread chef1 = new Thread(new Chef("Chef-1", "Pizza", 3000));
        Thread chef2 = new Thread(new Chef("Chef-2", "Pasta", 2000));
        Thread chef3 = new Thread(new Chef("Chef-3", "Salad", 1000));
        Thread chef4 = new Thread(new Chef("Chef-4", "Burger", 2500));

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}
