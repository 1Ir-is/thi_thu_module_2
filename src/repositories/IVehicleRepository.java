package repositories;

import java.util.List;

public interface IVehicleRepository<T> {
    List<T> findAll();
    void save(List<T> data);
    void add(T vehicle);
    void delete(String registrationNumber);
    List<T> searchByName(String keyword);
}
