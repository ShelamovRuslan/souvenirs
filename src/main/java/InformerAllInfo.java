public class InformerAllInfo {

    public void viewAllSouvenirs() {
        new ArrayListSouvenirs().getArrayListSouvenirs().forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
    }

    public void viewAllManufacturer () {
        new ArrayListManufacturer().getArrayListManufacturer().forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }
}
