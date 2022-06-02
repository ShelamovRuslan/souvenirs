import java.io.Serializable;
import java.util.*;


public class Manufacturer implements Serializable {


    private String idManufacturer;
    private String manufacturerName;
    private String country;

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public Manufacturer () {

    }

    public String getCountry() {
        return country;
    }
    public void viewInfoAllManufacturer() {
        returnListManufacturer().forEach(manufacturerTemp-> {
            infoManufacturer(manufacturerTemp);
            new Souvenirs().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new Souvenirs().infoProduct(souvenirs));
        });
    }

    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new Manufacturer().checkManufacturer(manufacturerName);
        new Souvenirs().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new Souvenirs().infoProduct(souvenirs));
    }


    public Manufacturer returnObjectManufacturerForManufacturerName (String manufacturerName){
        Manufacturer manufacturerTemp;
        if (returnAllManufactureName().contains(manufacturerName)){
            manufacturerTemp = returnListManufacturer().stream()
                    .filter(manufacturer -> manufacturer.getManufacturerName().equals(manufacturerName))
                    .findFirst()
                    .get();
            infoManufacturer(manufacturerTemp);
            if (new Console().yesOrNo()) {
                return manufacturerTemp;
            } else {
                System.out.println("Производителя с таким названием нет в базе");
                return null;
            }
        } else {
            System.out.println("Производителя с таким названием нет в базе");
            return null;
        }
    }

    public Manufacturer addNewManufacture () {
        System.out.println("Давайте добавим нового производителя в базу");
        Console console = new Console();
        this.manufacturerName = console.in("Введите название производителя");
        this.country = console.in("Введите страну производителя");
        this.idManufacturer = manufacturerName.toLowerCase() + country.toLowerCase();
        new CatalogManufacturer().addElementCatalogManufacturer(this);
        return this;
    }

    public void edit () {

    }

    public void viewAllManufacturer () {
        ArrayList<Manufacturer> listManufacturerTemp = returnListManufacturer();
        listManufacturerTemp.forEach(this::infoManufacturer);
    }

public Manufacturer checkManufacturer (String manufacturerName) {
    Manufacturer manufacturerTemp;
    if (returnAllManufactureName().contains(manufacturerName)){
    manufacturerTemp = returnListManufacturer().stream()
            .filter(manufacturer -> manufacturer.getManufacturerName().equals(manufacturerName))
            .findFirst()
            .get();
    } else {
       manufacturerTemp = addNewManufacture();
    }
    infoManufacturer(manufacturerTemp);
    if (new Console().yesOrNo()) {
        return manufacturerTemp;
    } else {
       return addNewManufacture();
    }
}

    public ArrayList<Manufacturer> returnListManufacturer () {
        ArrayList<Manufacturer> list = new ArrayList<>();
        CatalogManufacturer catalogManufacturerTemp = new CatalogManufacturer();
        catalogManufacturerTemp.restore();
        catalogManufacturerTemp.getCatalogManufacturer().forEach((s, manufacturer) -> list.add(manufacturer));
        return list;
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

    public Manufacturer(String idManufacturer, String manufacturerName, String country) {
        this.idManufacturer = idManufacturer;
        this.manufacturerName = manufacturerName;
        this.country = country;
    }

    public void infoManufacturer (Manufacturer manufacturer){
        System.out.printf("""
                
                Название производителя: %s
                Страна: %s
                
                """,
                manufacturer.getManufacturerName(),
                manufacturer.getCountry()
        );
    }

    public ArrayList<String> returnAllManufactureName (){
        ArrayList<String> listTemp = new ArrayList<>();
        returnListManufacturer().forEach(
           manufacturer -> listTemp.add(manufacturer.getManufacturerName())
        );
        return listTemp;
    }


}
