public class InformerAllInfo {

    public void viewAllSouvenirs() {
        new ArrayListSouvenirs().returnListSouvenirs().forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
    }

    public void viewAllManufacturer () {
        new ArrayListManufacturer().returnListManufacturer().forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }
}
