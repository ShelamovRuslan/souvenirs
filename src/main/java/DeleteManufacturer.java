public class DeleteManufacturer {
   private Console console = new Console();

public void deleteManufacturer () {
    ConcreteElementManufacturer concreteElementManufacturer = new ConcreteElementManufacturer(
            console.in("Введите название производителя"));
    Manufacturer manufacturerTempDelete = concreteElementManufacturer.getManufacturer();

                if (manufacturerTempDelete != null) {
        new CatalogSouvenirs().deleteManufactureSouvenirs(manufacturerTempDelete);
        new CatalogManufacturer().deleteElementCatalogManufacture(manufacturerTempDelete);
    }
}
}
