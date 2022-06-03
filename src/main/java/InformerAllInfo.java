import java.util.ArrayList;

public class InformerAllInfo {

    public void view() {
        new ArrayListElement().returnListSouvenirs().forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
    }

    public void viewAllManufacturer () {
        ArrayList<Manufacturer> listManufacturerTemp = new ArrayListElement().returnListManufacturer();
        listManufacturerTemp.forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }
}
