public class ParcelTrackerApp {
    public static void main(String[] args) {

        DeliveryPath path = new DeliveryPath();

        path.appendStage("Packed");
        path.appendStage("Shipped");
        path.appendStage("In Transit");
        path.appendStage("Delivered");

        path.trackParcel();

        path.insertCheckpoint("Shipped", "Customs Check");
        path.trackParcel();

        DeliveryPath missingParcel = new DeliveryPath();
        missingParcel.trackParcel(); // null handling
    }
}
