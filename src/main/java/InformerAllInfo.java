public class InformerAllInfo {

    public void viewAllSouvenirs() {
        new ArrayListElement().returnListSouvenirs().forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
    }

    public void viewAllManufacturer () {
        new ArrayListElement().returnListManufacturer().forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }
}
