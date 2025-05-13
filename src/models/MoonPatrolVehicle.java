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
}