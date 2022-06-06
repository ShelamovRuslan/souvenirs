import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Souvenirs implements Serializable {

    private String idNameSouvenirs;
    private String productName;

    private Manufacturer manufacturer;
    private double price;
    private String productionYear;
    private String productionMonth;

    public String getProductName() {
        return productName;
    }

    public Souvenirs() {

    }

    public void setProductionMonth(String productionMonth) {
        this.productionMonth = productionMonth;
    }

    public String getProductionMonth() {
        return productionMonth;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return price;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Souvenirs(String idNameSouvenirs, String productName, Manufacturer manufacturer, double price, String productionYear) {
        this.idNameSouvenirs = idNameSouvenirs;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.productionYear = productionYear;
    }

    public String getIdNameSouvenirs() {
        return idNameSouvenirs;
    }


    public void addNewSouvenir() {

        Console console = new Console();
        this.productName = console.in("Необходимо указать название сувенира");
        this.productionYear = console.in("Введите год производства");
        this.productionMonth = console.in("Введите месяц производства");
        this.price = Double.parseDouble(console.in("Укажите стоимость"));
        ConcreteElementManufacturer concrete = new ConcreteElementManufacturer(
                console.in("Введите название производителя"));
        Manufacturer manufacturerTempCreate = concrete.getManufacturer();


        if (manufacturerTempCreate != null){
            this.manufacturer = manufacturerTempCreate;
        } else {
           this.manufacturer = new Manufacturer().addNewManufacture();
        }

        new SaveCatalogSouvenirs(this).addElementCatalog();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souvenirs souvenirs = (Souvenirs) o;
        return Double.compare(souvenirs.price, price) == 0 && Objects.equals
                (idNameSouvenirs, souvenirs.idNameSouvenirs)
                && Objects.equals(productName, souvenirs.productName)
                && Objects.equals(manufacturer, souvenirs.manufacturer)
                && Objects.equals(productionYear, souvenirs.productionYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNameSouvenirs, productName, manufacturer, price, productionYear);
    }
}
