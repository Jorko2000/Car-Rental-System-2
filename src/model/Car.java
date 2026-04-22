package model;

/**
 * Car class extending Vehicle
 */
public class Car extends Vehicle {
    private String type;

    public Car(String id, String make, String model, int year, String type, boolean available) {
        super(id, make, model, year, available);
        this.type = type;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public void displayInfo() {
        System.out.println(id + " | " + make + " | " + model + " | " +
                year + " | " + type + " | " + (available ? "Available" : "Rented"));
    }
}
