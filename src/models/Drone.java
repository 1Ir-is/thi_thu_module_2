package models;

public class Drone extends Vehicle {
    private int maxRange;

    public Drone(String registrationNumber, String manufacturer, int productionYear, String coordinator, int maxRange) {
        super(registrationNumber, manufacturer, productionYear, coordinator);
        this.maxRange = maxRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public String toCSV() {
        return registrationNumber + "," + manufacturer + "," + productionYear + "," + coordinator + "," + maxRange;
    }

    @Override
    public String getDetails() {
        return "Drone [Registration: " + registrationNumber + ", Manufacturer: " + manufacturer +
                ", Year: " + productionYear + ", Coordinator: " + coordinator + ", Max Range: " + maxRange + " km]";
    }
}
