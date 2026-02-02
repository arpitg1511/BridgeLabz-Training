import java.util.*;
import java.util.regex.*;

// Abstract base class for any goods transport
abstract class Transport {
    protected String id;
    protected String date;
    protected int rating;

    Transport(String id, String date, int rating) {
        this.id = id;
        this.date = date;
        this.rating = rating;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    abstract public String selectVehicle();
    abstract public float computeTotalCharge();
}

// Brick transport class
class BrickLoad extends Transport {
    private float size;
    private int quantity;
    private float pricePerUnit;

    public BrickLoad(String id, String date, int rating, float size, int quantity, float pricePerUnit) {
        super(id, date, rating);
        this.size = size;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(float pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    @Override
    public String selectVehicle() {
        if (quantity < 300) return "Truck";
        if (quantity <= 500) return "Lorry";
        return "Monster Lorry";
    }

    @Override
    public float computeTotalCharge() {
        float basePrice = quantity * pricePerUnit;
        String vehicle = selectVehicle();
        float vehicleCost = 0;
        switch (vehicle) {
            case "Truck" -> vehicleCost = 1000;
            case "Lorry" -> vehicleCost = 1700;
            case "Monster Lorry" -> vehicleCost = 3000;
        }
        float tax = basePrice * 0.3f;
        float discount = 0;
        switch (rating) {
            case 5 -> discount = basePrice * 0.2f;
            case 3,4 -> discount = basePrice * 0.1f;
        }
        return (basePrice + vehicleCost + tax) - discount;
    }
}

// Timber transport class
class TimberLoad extends Transport {
    private float length;
    private float radius;
    private String type;
    private float pricePerUnit;

    public TimberLoad(String id, String date, int rating, float length, float radius, String type, float pricePerUnit) {
        super(id, date, rating);
        this.length = length;
        this.radius = radius;
        this.type = type;
        this.pricePerUnit = pricePerUnit;
    }

    public float getLength() { return length; }
    public void setLength(float length) { this.length = length; }

    public float getRadius() { return radius; }
    public void setRadius(float radius) { this.radius = radius; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public float getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(float pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    @Override
    public String selectVehicle() {
        float area = 2 * 3.147f * radius * length;
        if (area < 250) return "Truck";
        if (area <= 400) return "Lorry";
        return "Monster Lorry";
    }

    @Override
    public float computeTotalCharge() {
        float volume = 3.147f * radius * radius * length;
        float basePrice = volume * pricePerUnit * (type.equalsIgnoreCase("Premium") ? 0.25f : 0.15f);

        String vehicle = selectVehicle();
        float vehicleCost = 0;
        switch (vehicle) {
            case "Truck" -> vehicleCost = 1000;
            case "Lorry" -> vehicleCost = 1700;
            case "Monster Lorry" -> vehicleCost = 3000;
        }

        float tax = basePrice * 0.3f;
        float discount = 0;
        switch (rating) {
            case 5 -> discount = basePrice * 0.2f;
            case 3,4 -> discount = basePrice * 0.1f;
        }

        return (basePrice + vehicleCost + tax) - discount;
    }
}

// Utility class for parsing and validation
class TransportUtils {

    public Transport parseInput(String input) {
        String[] data = input.split(":");
        Transport t = null;
        String id = data[0];
        String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("brick")) {
            t = new BrickLoad(id, date, rating, Float.parseFloat(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]));
        } else if (type.equalsIgnoreCase("timber")) {
            t = new TimberLoad(id, date, rating, Float.parseFloat(data[4]), Float.parseFloat(data[5]), data[6], Float.parseFloat(data[7]));
        }
        return t;
    }

    public boolean validateId(String id) {
        String regex = "^RTS\\d{3}[A-Z]$";
        if (!Pattern.matches(regex, id)) {
            System.out.println("Transport ID " + id + " is invalid");
            return false;
        }
        return true;
    }

    public String getTransportType(Transport t) {
        if (t instanceof BrickLoad) return "Brick";
        if (t instanceof TimberLoad) return "Timber";
        return "Unknown";
    }
}

// Main interface
public class FutureLogistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransportUtils utils = new TransportUtils();

        System.out.println("Enter transport details:");
        String input = sc.nextLine();

        String id = input.split(":")[0];
        if (!utils.validateId(id)) {
            System.out.println("Invalid record provided!");
            return;
        }

        Transport t = utils.parseInput(input);
        String type = utils.getTransportType(t);

        System.out.println("Transport ID: " + t.getId());
        System.out.println("Date: " + t.getDate());
        System.out.println("Rating: " + t.getRating());

        if (type.equals("Brick")) {
            BrickLoad brick = (BrickLoad) t;
            System.out.println("Brick Quantity: " + brick.getQuantity());
            System.out.println("Brick Price: " + brick.getPricePerUnit());
            System.out.println("Vehicle: " + brick.selectVehicle());
            System.out.println("Total Charge: " + brick.computeTotalCharge());
        } else {
            TimberLoad timber = (TimberLoad) t;
            System.out.println("Timber Type: " + timber.getType());
            System.out.println("Timber Price per Unit: " + timber.getPricePerUnit());
            System.out.println("Vehicle: " + timber.selectVehicle());
            System.out.println("Total Charge: " + timber.computeTotalCharge());
        }
    }
}
