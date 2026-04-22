package model;

/**
 * Abstract class representing a general vehicle
 */
public abstract class Vehicle {
    protected String id;
    protected String make;
    protected String model;
    protected int year;
    protected boolean available;

    public Vehicle(String id, String make, String model, int year, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = available;
    }

    public abstract void displayInfo();

    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
