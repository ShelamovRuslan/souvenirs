public class InformerManufacturerSouvenirs {
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        ConcreteElementManufacturer concreteElementManufacturer = new ConcreteElementManufacturer(manufacturerName);
        manufacturerTemp = concreteElementManufacturer.getManufacturer();
        new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new ProductInfo().infoProduct(souvenirs));
    }
}
