package roundabout_flow;

class Roundabout {

    private VehicleNode head = null;

    // add vehicle to roundabout
    void addVehicle(String number) {
        VehicleNode newNode = new VehicleNode(number);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println(number + " entered roundabout");
    }

    // remove vehicle from roundabout
    void removeVehicle(String number) {

        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode curr = head;
        VehicleNode prev = null;

        do {
            if (curr.vehicleNumber.equals(number)) {

                if (curr == head && curr.next == head) {
                    head = null;
                }
                else {
                    if (curr == head) {
                        head = head.next;
                    }
                    if (prev != null) {
                        prev.next = curr.next;
                    }
                    else {
                        VehicleNode temp = head;
                        while (temp.next != curr) {
                            temp = temp.next;
                        }
                        temp.next = curr.next;
                    }
                }

                System.out.println(number + " exited roundabout");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Vehicle not found");
    }

    // print roundabout state
    void display() {

        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode temp = head;
        System.out.print("Roundabout: ");

        do {
            System.out.print(temp.vehicleNumber + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }
}

