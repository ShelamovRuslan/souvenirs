import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public String getIdNameSouvenirs() {
        return idNameSouvenirs;
    }

    public void add() {
        Console console = new Console();
        this.productName = console.in("Необходимо указать название сувенира");
        this.productionYear = console.in("Введите год производства");
        this.price = Double.parseDouble(console.in("Укажите стоимость"));
        this.manufacturer = new Manufacturer().checkManufacturer(console.in("Введите название производителя"));
        this.idNameSouvenirs = this.getProductName();
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        if (catalogSouvenirs.getCatalogSouvenirs().containsKey(this.getProductName())){
            int counter = 1;
            while (catalogSouvenirs.getCatalogSouvenirs().containsKey(idNameSouvenirs)) {
                idNameSouvenirs = this.getProductName() + counter;
                counter++;
            }
        }
        catalogSouvenirs.addElementCatalogSouvenirs(this);
    }

    public void edit() {

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

    public void view() {
        returnListSouvenirs().forEach(this::infoProduct);
    }

    public void viewSouvenirsYear(String name, String year) {
        returnListSouvenirs().stream()
                .filter(s -> s.getProductName().equals(name))
                .filter(souvenirs -> souvenirs.getProductionYear().equals(year))
                .forEach(s -> infoProduct(s));
    }

    public void viewAllSouvenirsGroupYear() {
        ArrayList<Souvenirs> list = returnListSouvenirs();
        Map<String, List<Souvenirs>> mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenirs::getProductionYear));
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProductionYear());
            mapSouvenirs.get(s).forEach(c -> infoProduct(c));
            });
    }

    public void infoProduct(Souvenirs souvenirs) {
        System.out.printf(
                """
                        
                        Название сувенира: %s
                        Год производства: %s
                        Цена сувенира: %s
                        Страна производства: %s
                        Производитель: %s
                        
                        """,
                souvenirs.getProductName(),
                souvenirs.getProductionYear(),
                souvenirs.getPrice(),
                souvenirs.getManufacturer().getCountry(),
                souvenirs.getManufacturer().getManufacturerName()
        );
    }

    public void country() {
        Console console = new Console();
        String country = console.in("Необходимо указать название страны");
        System.out.printf("\nВ стране %s были произведены:\n", country);
        new Manufacturer()
                .returnListManufacturer()
                .stream()
                .filter(s -> s.getCountry().equals(country))
                .forEach(this::viewManufacturerSouvenirsTemp);
    }

    public void price() {
        Console console = new Console();
        String priceTemp = console.in("Укажите цену");
        double price = Double.parseDouble(priceTemp.replace(',','.'));
        System.out.print("\nСписок производителей у которых есть цены на сувениры ниже указанной\n");
        returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.price < price)
                .forEach(souvenirs -> new Manufacturer().infoManufacturer(souvenirs.getManufacturer()));
    }

    public void viewManufacturerSouvenirsTemp (Manufacturer manufacturer) {
        returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(souvenirs ->  new Souvenirs().infoProduct(souvenirs));
    }



    public void setContext() {

    }

    public ArrayList<Souvenirs> returnListSouvenirs() {
        ArrayList<Souvenirs> list = new ArrayList<>();
        CatalogSouvenirs catalogSouvenirsTemp = new CatalogSouvenirs();
        catalogSouvenirsTemp.restore();
        catalogSouvenirsTemp.getCatalogSouvenirs().forEach((s, souvenirs) -> list.add(souvenirs));
        return list;
    }

    public Souvenirs(String idNameSouvenirs, String productName, Manufacturer manufacturer, double price, String productionYear) {
        this.idNameSouvenirs = idNameSouvenirs;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.productionYear = productionYear;
    }
}
