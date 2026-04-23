package model;

public class Car extends Vehicle {
    private String type;
    private String status; // Available / Rented
    private String currentRenter;

    public Car(String id, String make, String model, int year,
               String type, String status, String currentRenter) {

        super(id, make, model, year, status.equals("Available"));
        this.type = type;
        this.status = status;
        this.currentRenter = currentRenter;
    }

    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getCurrentRenter() { return currentRenter; }

    public void setStatus(String status) {
        this.status = status;
        this.available = status.equals("Available");
    }

    public void setCurrentRenter(String renter) {
        this.currentRenter = renter;
    }

    @Override
    public void displayInfo() {
        System.out.println(id + " | " + make + " | " + model + " | " +
                year + " | " + type + " | " + status +
                " | " + (currentRenter.isEmpty() ? "None" : currentRenter));
    }
}
