package repositories;

import models.MoonPatrolVehicle;
import utils.SaveFileUtils;

import java.util.ArrayList;
import java.util.List;

public class MoonPatrolVehicleRepository implements IVehicleRepository<MoonPatrolVehicle> {
    private static final String MOON_PATROL_VEHICLE_FILE = "src/datas/xeTuanTra.csv";

    @Override
    public List<MoonPatrolVehicle> findAll() {
        List<String> lines = SaveFileUtils.readFromFile(MOON_PATROL_VEHICLE_FILE);
        List<MoonPatrolVehicle> moonPatrolVehicles = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("," , 2);
            if (parts.length > 1 && "MoonPatrolVehicle".equals(parts[0])) {
                moonPatrolVehicles.add(MoonPatrolVehicle.fromCSV(parts[1]));
            }
        }
        return moonPatrolVehicles;
    }

    @Override
    public void save(List<MoonPatrolVehicle> data) {
        List<String> result = new ArrayList<>();
        List<String> lines = SaveFileUtils.readFromFile(MOON_PATROL_VEHICLE_FILE);
        for (String line : lines) {
            if (!line.startsWith("MoonPatrolVehicle,")) {
                result.add(line);
            }
        }
        for (MoonPatrolVehicle moonPatrolVehicle : data) {
            result.add("MoonPatrolVehicle," + moonPatrolVehicle.toCSV());
        }
        SaveFileUtils.writeToFile(MOON_PATROL_VEHICLE_FILE, result, false);
    }

    @Override
    public void add(MoonPatrolVehicle vehicle) {
        List<MoonPatrolVehicle> current = findAll();
        current.add(vehicle);
        save(current);
    }

    @Override
    public void delete(String registrationNumber) {
        List<MoonPatrolVehicle> current = findAll();
        for (int i = 0; i < current.size(); i++) {
            if (current.get(i).getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                current.remove(i);
                break;
            }
        }
        save(current);
    }

    @Override
    public List<MoonPatrolVehicle> searchByName(String keyword) {
        List<MoonPatrolVehicle> result = new ArrayList<>();
        List<MoonPatrolVehicle> current = findAll();
        for (MoonPatrolVehicle moonPatrolVehicle : current) {
            if (moonPatrolVehicle.getCoordinator().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(moonPatrolVehicle);
            }
        }
        return result;
    }
}
