import lombok.NonNull;

import java.util.ArrayList;

public class ManufacturerMethods {
    public void viewInfoAllManufacturer() {
        new ArrayListElement().returnListManufacturer().forEach(manufacturerTemp-> {
            new ProductInfo().infoManufacturer(manufacturerTemp);
            new ArrayListElement().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
        });
    }
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new ConcreteElement().returnObjectManufacturerForManufacturerName(manufacturerName);
        new SouvenirsMethods().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new ProductInfo().infoProduct(souvenirs));
    }
    public void viewAllManufacturer () {
        ArrayList<Manufacturer> listManufacturerTemp = new ArrayListElement().returnListManufacturer();
        listManufacturerTemp.forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }



}
