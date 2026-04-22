package interfaces;

import model.Customer;

public interface Rentable {
    void rentCar(String carId, Customer customer, String start, String end);
    void returnCar(String carId);
}
