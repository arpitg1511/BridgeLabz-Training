class CircularTrack {
    private CarNode start;

    public void enterCar(CarNode car) {
        if (start == null) {
            start = car;
            car.link = start;
            return;
        }

        CarNode temp = start;
        while (temp.link != start) {
            temp = temp.link;
        }
        temp.link = car;
        car.link = start;
    }

    public void exitCar(int carNumber) {
        if (start == null) {
            System.out.println("No cars present in the roundabout.");
            return;
        }

        CarNode current = start;
        CarNode previous = null;

        do {
            if (current.getCarNumber() == carNumber) {

                if (previous != null) {
                    previous.link = current.link;
                } else {
                    CarNode last = start;
                    while (last.link != start) {
                        last = last.link;
                    }
                    start = start.link;
                    last.link = start;
                }

                System.out.println("Car " + carNumber + " has exited.");
                return;
            }
            previous = current;
            current = current.link;
        } while (current != start);

        System.out.println("Car not found inside the roundabout.");
    }

    public void displayTraffic() {
        if (start == null) {
            System.out.println("Roundabout is currently empty.");
            return;
        }

        CarNode temp = start;
        System.out.print("Cars in roundabout: ");
        do {
            System.out.print(temp.getCarNumber() + " -> ");
            temp = temp.link;
        } while (temp != start);
        System.out.println("LOOP");
    }
}
