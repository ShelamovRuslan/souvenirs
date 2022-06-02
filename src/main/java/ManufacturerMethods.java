public class ManufacturerMethods {
    public void viewInfoAllManufacturer() {
        new Manufacturer().returnListManufacturer().forEach(manufacturerTemp-> {
            new Manufacturer().infoManufacturer(manufacturerTemp);
            new Souvenirs().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new Souvenirs().infoProduct(souvenirs));
        });
    }
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new Manufacturer().returnObjectManufacturerForManufacturerName(manufacturerName);
        new Souvenirs().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new Souvenirs().infoProduct(souvenirs));
    }

}
