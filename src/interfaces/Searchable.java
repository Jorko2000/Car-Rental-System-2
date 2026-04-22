package interfaces;

public interface Searchable {
    void searchById(String id);
    void searchByModel(String model);
    void searchByAvailability(boolean available);
}
