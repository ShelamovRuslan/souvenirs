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

    public Souvenirs(String productName, Manufacturer manufacturer, double price, String productionYear) {
        this.idNameSouvenirs = String.valueOf(new CatalogSouvenirs().getCatalogSouvenirs().size());
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
        this.price = Double.parseDouble(console.in("Укажите стоимость"));
        Manufacturer manufacturerTempCreate = new ManufacturerMethods()
                .returnObjectManufacturerForManufacturerName(
                        console.in("Введите название производителя"));
        if (manufacturerTempCreate != null){
            this.manufacturer = manufacturerTempCreate;
        } else {
           this.manufacturer = new Manufacturer().addNewManufacture();
        }
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        this.idNameSouvenirs = String.valueOf(catalogSouvenirs.getCatalogSouvenirs().size());
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
