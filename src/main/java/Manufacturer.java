import java.io.Serializable;
import java.util.*;


public class Manufacturer implements Serializable {


    private String idManufacturer;
    private String manufacturerName;
    private String country;

    public Manufacturer () {

    }
    public Manufacturer(String idNameSouvenirs, String manufacturerName, String country) {
        this.idManufacturer = idNameSouvenirs;
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

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Manufacturer addNewManufacture () {

        System.out.println("Давайте добавим нового производителя в базу");
        Console console = new Console();
        this.manufacturerName = console.in("Введите название производителя");
        this.country = console.in("Введите страну производителя");
        this.idManufacturer = String.valueOf(new CatalogManufacturer().getCatalogManufacturer().size());
        new CatalogManufacturer().addElementCatalogManufacturer(this);
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerName, country);
    }
}
