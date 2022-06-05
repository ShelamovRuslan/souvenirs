public class InformerAllManufacturerAndSouvenirs {
    public void viewInfoAllManufacturer() {
        new ArrayListManufacturer().getArrayListManufacturer().forEach(manufacturerTemp-> {
            new ProductInfo().infoManufacturer(manufacturerTemp);
            new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
        });
    }
}
