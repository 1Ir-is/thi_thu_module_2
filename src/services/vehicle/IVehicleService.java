package services.vehicle;

import java.util.List;

public interface IVehicleService<T> {
    List<T> findAll();
    void add(T vehicle);
    void delete(String registrationNumber);
    List<T> searchByNameCoordinator(String keyword);
    T findById(String registrationNumber);
}