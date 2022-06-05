public class Price {
    public void price() {
        Console console = new Console();
        String priceTemp = console.in("Укажите цену");
        double price = Double.parseDouble(priceTemp.replace(',','.'));
        System.out.print("\nСписок производителей у которых есть цены на сувениры ниже указанной\n");
        new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getPrice() < price)
                .forEach(souvenirs -> new ProductInfo().infoManufacturer(souvenirs.getManufacturer()));
    }
}
