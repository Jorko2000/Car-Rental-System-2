package model;

/**
 * Rental entity linking Car and Customer
 */
public class Rental {
    private Car car;
    private Customer customer;
    private String startDate;
    private String endDate;

    public Rental(Car car, Customer customer, String startDate, String endDate) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Car getCar() { return car; }

    public void displayRental() {
        System.out.println(customer.getName() + " rented " + car.getId() +
                " from " + startDate + " to " + endDate);
    }
}
