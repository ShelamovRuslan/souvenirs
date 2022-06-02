import java.io.Serializable;
import java.util.*;


public class Manufacturer implements Serializable {


    private String idManufacturer;
    private String manufacturerName;
    private String country;

    public Manufacturer () {

    }
    public Manufacturer(String idManufacturer, String manufacturerName, String country) {
        this.idManufacturer = idManufacturer;
        this.manufacturerName = manufacturerName;
        this.country = country;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public String getCountry() {
        return country;
    }

    public Manufacturer addNewManufacture () {
        // Планирую переделать в билдер
        System.out.println("Давайте добавим нового производителя в базу");
        Console console = new Console();
        this.manufacturerName = console.in("Введите название производителя");
        this.country = console.in("Введите страну производителя");
        this.idManufacturer = manufacturerName.toLowerCase() + country.toLowerCase();
        new CatalogManufacturer().addElementCatalogManufacturer(this);
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(idManufacturer, that.idManufacturer) && Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManufacturer, manufacturerName, country);
    }
}
