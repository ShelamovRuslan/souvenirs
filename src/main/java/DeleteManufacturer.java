public class DeleteManufacturer {
   private Console console = new Console();

public void deleteManufacturer () {
    Manufacturer manufacturerTempDelete =
            new ConcreteElement().returnObjectManufacturerForManufacturerName(
                    console.in("Введите название производителя")
            );
                if (manufacturerTempDelete != null) {
        new CatalogSouvenirs().deleteManufactureSouvenirs(manufacturerTempDelete);
        new CatalogManufacturer().deleteElementCatalogManufacture(manufacturerTempDelete);
    }
}
}
