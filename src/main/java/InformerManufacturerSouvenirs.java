public class InformerManufacturerSouvenirs {
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new ConcreteElement().returnObjectManufacturerForManufacturerName(manufacturerName);
        new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new ProductInfo().infoProduct(souvenirs));
    }
}
