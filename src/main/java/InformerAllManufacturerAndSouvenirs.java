public class InformerAllManufacturerAndSouvenirs {
    public void viewInfoAllManufacturer() {
        new ArrayListElement().returnListManufacturer().forEach(manufacturerTemp-> {
            new ProductInfo().infoManufacturer(manufacturerTemp);
            new ArrayListElement().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
        });
    }
}
