public class InformerCountry {
    public void country() {
        Console console = new Console();
        String country = console.in("Необходимо указать название страны");
        System.out.printf("\nВ стране %s были произведены:\n", country);
        new ArrayListManufacturer()
                .getArrayListManufacturer()
                .stream()
                .filter(s -> s.getCountry().equals(country))
                .forEach(this::viewManufacturerSouvenirsTemp);
    }

    public void viewManufacturerSouvenirsTemp (Manufacturer manufacturer) {
        new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(souvenirs ->  new ProductInfo().infoProduct(souvenirs));
    }

}
