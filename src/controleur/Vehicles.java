package controleur;

public class Vehicles {
    private String licenseplate, mileage, brand, status;
    private int idvehicles;

    public Vehicles(int idvehicles, String licenseplate, String mileage, String brand, String status)
    {
        this.idvehicles = idvehicles;
        this.licenseplate = licenseplate;
        this.mileage = mileage;
        this.brand = brand;
        this.status = status;
    }

    public Vehicles(String licenseplate, String mileage, String brand, String status)
    {
        this.licenseplate = licenseplate;
        this.mileage = mileage;
        this.brand = brand;
        this.status = status;
    }

    public Vehicles(String licenseplate)
    {
        this.licenseplate = licenseplate;
    }

    @Override
    public String toString() {
        return "Numéro : " +getIdvehicles()+ "\n" + " Plaque d'immatriculation : " + getlicenseplate() + "\n" + "Kilométrage : " + getMileage() +
                "\n" + "Marque : " + getBrand() + "\n" + "Statut : " + getStatus() + "\n";
    }

    public int getIdvehicles() {
        return idvehicles;
    }

    public void setIdvehicles(int idvehicles) {
        this.idvehicles = idvehicles;
    }

    public String getlicenseplate() {
        return licenseplate;
    }

    public void setlicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}