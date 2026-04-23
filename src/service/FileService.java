package service;

import model.Car;
import java.io.*;
import java.util.*;

public class FileService {

    // READ CSV
    public static List<Car> readFromCSV(String path) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String renter = data.length > 6 ? data[6] : "";

                Car car = new Car(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4],
                        data[5],
                        renter
                );

                cars.add(car);
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return cars;
    }

    // WRITE CSV
    public static void writeToCSV(String path, List<Car> cars) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (Car car : cars) {
                bw.write(car.getId() + "," +
                        car.getMake() + "," +
                        car.getModel() + "," +
                        car.getYear() + "," +
                        car.getType() + "," +
                        car.getStatus() + "," +
                        (car.getCurrentRenter() == null ? "" : car.getCurrentRenter()));
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
