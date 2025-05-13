package models;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String manufacturer;
    protected int productionYear;
    protected String coordinator;

    public Vehicle(String registrationNumber, String manufacturer, int productionYear, String coordinator) {
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.coordinator = coordinator;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public abstract String toCSV();
    public abstract String getDetails();
}
