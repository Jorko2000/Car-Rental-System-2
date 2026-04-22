import service.*;
import model.*;

import java.util.*;

/**
 * Console UI
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RentalService service = new RentalService();

        // Load CSV data
        service.getCars().addAll(FileService.readFromCSV("data/cars.csv"));

        while (true) {
            System.out.println("\n--- CAR RENTAL SYSTEM ---");
            System.out.println("1. Add Car");
            System.out.println("2. List Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Search by Model");
            System.out.println("6. Exit");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Make: ");
                        String make = sc.nextLine();

                        System.out.print("Model: ");
                        String model = sc.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine());

                        System.out.print("Type: ");
                        String type = sc.nextLine();

                        service.addCar(new Car(id, make, model, year, type, true));
                        break;

                    case 2:
                        service.listCars();
                        break;

                    case 3:
                        System.out.print("Car ID: ");
                        String carId = sc.nextLine();

                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();

                        Customer customer = new Customer(UUID.randomUUID().toString(), name);

                        service.rentCar(carId, customer, "today", "tomorrow");
                        break;

                    case 4:
                        System.out.print("Car ID: ");
                        service.returnCar(sc.nextLine());
                        break;

                    case 5:
                        System.out.print("Model: ");
                        service.searchByModel(sc.nextLine());
                        break;

                    case 6:
                        FileService.writeToCSV("data/cars.csv", service.getCars());
                        System.out.println("Data saved. Exiting...");
                        return;
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
