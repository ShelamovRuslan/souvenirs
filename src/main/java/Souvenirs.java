import java.io.Serializable;
import java.util.Objects;

public class Souvenirs implements Serializable {

    private String idNameSouvenirs;
    private String productName;

    private Manufacturer manufacturer;
    private double price;
    private String productionYear;

    public String getProductName() {
        return productName;
    }

    public Souvenirs() {

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

    public void add() {
        //Планирую переделать в билдер
        Console console = new Console();
        this.productName = console.in("Необходимо указать название сувенира");
        this.productionYear = console.in("Введите год производства");
        this.price = Double.parseDouble(console.in("Укажите стоимость"));
        this.manufacturer = new ManufacturerMethods()
                .returnObjectManufacturerForManufacturerName(
                        console.in("Введите название производителя"));
        this.idNameSouvenirs = this.getProductName();
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        if (catalogSouvenirs.getCatalogSouvenirs().containsKey(this.getProductName())) {
            int counter = 1;
            while (catalogSouvenirs.getCatalogSouvenirs().containsKey(idNameSouvenirs)) {
                idNameSouvenirs = this.getProductName() + counter;
                counter++;
            }
        }
        catalogSouvenirs.addElementCatalogSouvenirs(this);
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
