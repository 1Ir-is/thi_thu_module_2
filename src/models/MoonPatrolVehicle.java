package models;

public class MoonPatrolVehicle extends Vehicle {
    private int radiationResistanceLevel;

    public MoonPatrolVehicle(String registrationNumber, String manufacturer, int productionYear, String coordinator, int radiationResistanceLevel) {
        super(registrationNumber, manufacturer, productionYear, coordinator);
        this.radiationResistanceLevel = radiationResistanceLevel;
    }

    @Override
    public String toCSV() {
        return registrationNumber + "," + manufacturer + "," + productionYear + "," + coordinator + "," + radiationResistanceLevel;
    }

    @Override
    public String getDetails() {
        return "Moon Patrol Vehicle [Registration: " + registrationNumber + ", Manufacturer: " + manufacturer +
                ", Year: " + productionYear + ", Coordinator: " + coordinator + ", Radiation Resistance: Level " + radiationResistanceLevel + "]";
    }

    @Override
    public String toString() {
        return getDetails();
    }

    public static MoonPatrolVehicle fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new MoonPatrolVehicle(
                parts[0],
                parts[1],
                Integer.parseInt(parts[2]),
                parts[3],
                Integer.parseInt(parts[4])
        );
    }
}