package NotificationFiltering;

class Alert {
    String message;
    String type;   // EMERGENCY, MEDICATION, APPOINTMENT, GENERAL

    Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " ALERT: " + message;
    }
}

