public class ManufacturerMethods {
    public void viewInfoAllManufacturer() {
        new Manufacturer().returnListManufacturer().forEach(manufacturerTemp-> {
            new Manufacturer().infoManufacturer(manufacturerTemp);
            new Souvenirs().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new Souvenirs().infoProduct(souvenirs));
        });
    }
}
