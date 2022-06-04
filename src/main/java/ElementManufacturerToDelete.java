public class ElementManufacturerToDelete {

    private String nameManufacturer;

    private Manufacturer concreteManufacturer;

    public ElementManufacturerToDelete(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
        createElementManufacturerToDelete();
    }

    private void createElementManufacturerToDelete() {
        ConcreteElementManufacturer concreteElementManufacturer =
                new ConcreteElementManufacturer(this.nameManufacturer);
        concreteManufacturer = concreteElementManufacturer.getManufacturer();
    }

    public boolean deleteManufacturer () {
        if (concreteManufacturer != null) {
            new CatalogSouvenirs().deleteManufactureSouvenirs(concreteManufacturer);
            new CatalogManufacturer().deleteElementCatalogManufacture(concreteManufacturer);
            return true;
        } else {
            return false;
        }
    }
}
