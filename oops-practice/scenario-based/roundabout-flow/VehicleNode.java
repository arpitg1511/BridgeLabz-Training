package roundabout_flow;

class VehicleNode {

    String vehicleNumber;
    VehicleNode next;

    VehicleNode(String number) {
        this.vehicleNumber = number;
        this.next = null;
    }
}
