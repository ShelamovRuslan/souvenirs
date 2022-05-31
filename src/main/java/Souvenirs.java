import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Souvenirs implements Serializable{
    private String idSouvenirs;
    private String productName;
    private String manufacturerId;
    private Manufacturer manufacturer;
    private double price;
    private String  productionYear;

    public String getProductName() {
        return productName;
    }

    public Souvenirs () {

    }

    public void add () {
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        catalogSouvenirs.restore();
        Console console = new Console();
        this.productName = console.in("Необходимо указать название сувенира");
        this.productionYear = console.in("Введите год производства");
        this.price = Double.parseDouble(console.in("Укажите стоимость"));
        this.manufacturerId = new Manufacturer().check(console.in("Введите название производителя"));
        catalogSouvenirs.addElementCatalogSouvenirs(this);
        catalogSouvenirs.save();
    }

    public void edit () {

    }

    public void view () {

    }

    public void setContext () {

    }

}
