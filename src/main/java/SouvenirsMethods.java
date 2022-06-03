import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SouvenirsMethods {


    public ArrayList<Souvenirs> returnArrayListSouvenirsYear(String name, String year) {
        ArrayList<Souvenirs> listArrayList = new ArrayList<>();
        new ArrayListElement().returnListSouvenirs().stream()
                .filter(s -> s.getProductName().equals(name))
                .filter(souvenirs -> souvenirs.getProductionYear().equals(year))
                .forEach(listArrayList::add);
        return listArrayList;
    }

    public void viewAllSouvenirsGroupYear() {
        ArrayList<Souvenirs> list = new ArrayListElement().returnListSouvenirs();
        Map<String, List<Souvenirs>> mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenirs::getProductionYear));
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProductionYear());
            mapSouvenirs.get(s).forEach(c -> new ProductInfo().infoProduct(c));
        });
    }
    public void price() {
        Console console = new Console();
        String priceTemp = console.in("Укажите цену");
        double price = Double.parseDouble(priceTemp.replace(',','.'));
        System.out.print("\nСписок производителей у которых есть цены на сувениры ниже указанной\n");
        new ArrayListElement().returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getPrice() < price)
                .forEach(souvenirs -> new ProductInfo().infoManufacturer(souvenirs.getManufacturer()));
    }



    public ArrayList <Souvenirs> returnArrayListSouvenirsConcreteManufacture (Manufacturer manufacturer){
        ArrayList<Souvenirs> arrayListSouvenirsTemp = new ArrayList<>();
        new ArrayListElement().returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(arrayListSouvenirsTemp::add);
        return arrayListSouvenirsTemp;
    }







}
