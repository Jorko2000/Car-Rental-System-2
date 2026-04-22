package service;

import model.*;
import interfaces.*;
import java.util.*;

/**
 * Core business logic
 */
public class RentalService implements Rentable, Searchable {

    private List<Car> cars = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void listCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        for (Car car : cars) {
            car.displayInfo();
        }
    }

    public void editCar(String id, String newMake, String newModel, int newYear, String newType) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.setAvailable(car.isAvailable());
                System.out.println("Car updated.");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    public void removeCar(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.setAvailable(false);
                System.out.println("Car removed (flagged unavailable).");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    @Override
    public void rentCar(String carId, Customer customer, String start, String end) {
        for (Car car : cars) {
            if (car.getId().equals(carId) && car.isAvailable()) {
                car.setAvailable(false);
                rentals.add(new Rental(car, customer, start, end));
                System.out.println("Car rented successfully!");
                return;
            }
        }
        System.out.println("Car not available.");
    }

    @Override
    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                car.setAvailable(true);
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    // SEARCH
    @Override
    public void searchById(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                car.displayInfo();
            }
        }
    }

    @Override
    public void searchByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                car.displayInfo();
            }
        }
    }

    @Override
    public void searchByAvailability(boolean available) {
        for (Car car : cars) {
            if (car.isAvailable() == available) {
                car.displayInfo();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
