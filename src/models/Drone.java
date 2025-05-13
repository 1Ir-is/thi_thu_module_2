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

    public static Drone fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Drone(
                parts[0],
                parts[1],
                Integer.parseInt(parts[2]),
                parts[3],
                Integer.parseInt(parts[4])
        );
    }
}
