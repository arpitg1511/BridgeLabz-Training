public class TrafficController {
    public static void main(String[] args) {

        CircularTrack track = new CircularTrack();
        EntryQueue queue = new EntryQueue(3);

        queue.addToQueue(201);
        queue.addToQueue(202);
        queue.addToQueue(203);
        queue.addToQueue(204); // overflow case

        while (queue.hasWaitingCars()) {
            Integer carId = queue.allowEntry();
            if (carId != null) {
                track.enterCar(new CarNode(carId));
            }
        }

        track.displayTraffic();

        track.exitCar(202);
        track.displayTraffic();

        track.exitCar(999); // invalid removal
    }
}
