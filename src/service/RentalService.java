@Override
public void rentCar(String carId, Customer customer, String start, String end) {
    for (Car car : cars) {
        if (car.getId().equals(carId) && car.getStatus().equals("Available")) {

            car.setStatus("Rented");
            car.setCurrentRenter(customer.getName());

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

            car.setStatus("Available");
            car.setCurrentRenter("");

            System.out.println("Car returned successfully.");
            return;
        }
    }
    System.out.println("Car not found.");
}
