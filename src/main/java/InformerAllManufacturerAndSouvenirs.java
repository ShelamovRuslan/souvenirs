public class InformerAllManufacturerAndSouvenirs {
    public void viewInfoAllManufacturer() {
        new ArrayListManufacturer().returnListManufacturer().forEach(manufacturerTemp-> {
            new ProductInfo().infoManufacturer(manufacturerTemp);
            new ArrayListSouvenirs().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
        });
    }
}
