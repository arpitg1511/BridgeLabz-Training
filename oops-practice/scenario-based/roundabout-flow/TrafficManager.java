package roundabout_flow;

public class TrafficManager {

    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        // vehicles arrive
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); // overflow

        // allow vehicles into roundabout
        if (!waitingQueue.isEmpty())
            roundabout.addVehicle(waitingQueue.dequeue());

        if (!waitingQueue.isEmpty())
            roundabout.addVehicle(waitingQueue.dequeue());

        roundabout.display();

        // exit vehicle
        roundabout.removeVehicle("CAR-101");
        roundabout.display();

        // next vehicle enters
        if (!waitingQueue.isEmpty())
            roundabout.addVehicle(waitingQueue.dequeue());

        roundabout.display();
    }
}

