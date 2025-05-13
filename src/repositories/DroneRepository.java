package repositories;

import models.Drone;
import utils.SaveFileUtils;

import java.util.ArrayList;
import java.util.List;

public class DroneRepository implements IVehicleRepository<Drone> {
    private static final String DRONE_FILE = "src/datas/drone.csv";

    @Override
    public List<Drone> findAll() {
        List<String> lines = SaveFileUtils.readFromFile(DRONE_FILE);
        List<Drone> drones = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",", 2);
            if (parts.length > 1 && "Drone".equals(parts[0])) {
                drones.add(Drone.fromCSV(parts[1]));
            }
        }
        return drones;
    }

    @Override
    public void save(List<Drone> data) {
        List<String> result = new ArrayList<>();
        List<String> lines = SaveFileUtils.readFromFile(DRONE_FILE);
        for (String line : lines) {
            if (!line.startsWith("Drone,")) {
                result.add(line);
            }
        }
        for (Drone drone : data) {
            result.add("Drone," + drone.toCSV());
        }
        SaveFileUtils.writeToFile(DRONE_FILE, result, false);
    }

    @Override
    public void add(Drone vehicle) {
        List<Drone> current = findAll();
        current.add(vehicle);
        save(current);
    }

    @Override
    public void delete(String registrationNumber) {
        List<Drone> current = findAll();
        for (int i = 0; i < current.size(); i++) {
            if (current.get(i).getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                current.remove(i);
                break;
            }
        }
        save(current);
    }

    @Override
    public List<Drone> searchByName(String keyword) {
        List<Drone> result = new ArrayList<>();
        List<Drone> current = findAll();
        for (Drone drone : current) {
            if (drone.getCoordinator().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(drone);
            }
        }
        return result;
    }

    public Drone findById(String registrationNumber) {
        List<Drone> current = findAll();
        for (Drone drone : current) {
            if (drone.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return drone;
            }
        }
        return null;
    }

}
