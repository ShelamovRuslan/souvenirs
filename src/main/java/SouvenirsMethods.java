import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SouvenirsMethods {
    public void view() {
        returnListSouvenirs().forEach(this::infoProduct);
    }

    public ArrayList<Souvenirs> returnListSouvenirs() {
        ArrayList<Souvenirs> list = new ArrayList<>();
        CatalogSouvenirs catalogSouvenirsTemp = new CatalogSouvenirs();
        catalogSouvenirsTemp.restore();
        catalogSouvenirsTemp.getCatalogSouvenirs().forEach((s, souvenirs) -> list.add(souvenirs));
        return list;
    }

    public ArrayList<Souvenirs> returnArrayListSouvenirsYear(String name, String year) {
        ArrayList<Souvenirs> listArrayList = new ArrayList<>();
        returnListSouvenirs().stream()
                .filter(s -> s.getProductName().equals(name))
                .filter(souvenirs -> souvenirs.getProductionYear().equals(year))
                .forEach(listArrayList::add);
        return listArrayList;
    }

    public void viewAllSouvenirsGroupYear() {
        ArrayList<Souvenirs> list = returnListSouvenirs();
        Map<String, List<Souvenirs>> mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenirs::getProductionYear));
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProductionYear());
            mapSouvenirs.get(s).forEach(c -> infoProduct(c));
        });
    }
    public void price() {
        Console console = new Console();
        String priceTemp = console.in("Укажите цену");
        double price = Double.parseDouble(priceTemp.replace(',','.'));
        System.out.print("\nСписок производителей у которых есть цены на сувениры ниже указанной\n");
        returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getPrice() < price)
                .forEach(souvenirs -> new ManufacturerMethods().infoManufacturer(souvenirs.getManufacturer()));
    }

    public void viewManufacturerSouvenirsTemp (Manufacturer manufacturer) {
        returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(souvenirs ->  new SouvenirsMethods().infoProduct(souvenirs));
    }

    public ArrayList <Souvenirs> returnArrayListSouvenirsConcreteManufacture (Manufacturer manufacturer){
        ArrayList<Souvenirs> arrayListSouvenirsTemp = new ArrayList<>();
        new SouvenirsMethods().returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(arrayListSouvenirsTemp::add);
        return arrayListSouvenirsTemp;
    }

    public void country() {
        Console console = new Console();
        String country = console.in("Необходимо указать название страны");
        System.out.printf("\nВ стране %s были произведены:\n", country);
        new ManufacturerMethods ()
                .returnListManufacturer()
                .stream()
                .filter(s -> s.getCountry().equals(country))
                .forEach(this::viewManufacturerSouvenirsTemp);
    }

    public void infoProduct(Souvenirs souvenirs) {
        System.out.printf(
                """
                        
                        Название сувенира: %s
                        Год производства: %s
                        Цена сувенира: %s
                        Страна производства: %s
                        Производитель: %s
                        
                        """,
                souvenirs.getProductName(),
                souvenirs.getProductionYear(),
                souvenirs.getPrice(),
                souvenirs.getManufacturer().getCountry(),
                souvenirs.getManufacturer().getManufacturerName()
        );
    }

}
