import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

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

    public void infoProduct(@NonNull Souvenirs souvenirs) {
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

    public Souvenirs editeSouvenirs (@NonNull Souvenirs souvenirs){

        Console console = new Console();
        int answer = Integer.parseInt( console.in("""
                Какие именно изменения вы желаете внести?
                1) Изменить название
                2) Изменить цену
                3) Изменить год изготовления
                4) Изменить название изготовителя
                5) Изменить страну изготовителя
                """));
        if (answer == 1){
            souvenirs.setProductName(console.in("Введите имя"));
        } else if (answer == 2){
            souvenirs.setPrice(Double.parseDouble(console.in("Введите цену")));
        } else if (answer == 3){
            souvenirs.setProductionYear(console.in("Введите год"));
        } else if (answer == 4){
            souvenirs.getManufacturer().setManufacturerName(console.in("Введите название производителя"));

        } else if (answer == 5){
            souvenirs.getManufacturer().setCountry(console.in("Введите название страны"));
        }
        return souvenirs;
    }

 /*   public void editeAllManufactureRequisites (Souvenirs souvenirs) {
        String tempCountry =  souvenirs.getManufacturer().getCountry();
        String tempName = souvenirs.getManufacturer().getManufacturerName();
        Console console = new Console();
        System.out.println("Желаете внести изменения во всех сувенирах?");
        int answer = Integer.parseInt( console.in("""
                Какие именно изменения вы желаете внести?
                1) Да
                2) Нет
                """));
        if (answer == 1) {

        }
    }*/

/*public void test (){

        searchConcreteSouvenir(searchConcreteSouvenir("null"));
    }

    */
@Nullable
    public Souvenirs searchConcreteSouvenir (@NonNull String nameSouvenir) {
        int counter = 0;
        ArrayList<Souvenirs> souvenirsTempList = new ArrayList<>();
        if (!returnArrayListNameSouvenir(nameSouvenir).isEmpty()) {
            new SouvenirsMethods().returnListSouvenirs().stream()
                    .filter(souvenirs -> souvenirs.getProductName().equals(nameSouvenir))
                    .forEach(souvenirsTempList::add);
        } else {
            System.out.println("Такого сувенира нет в списке");
            return null;
        }

        for ( ;counter < souvenirsTempList.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new SouvenirsMethods().infoProduct(souvenirsTempList.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        Console console = new Console();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Сувенира с таким параметрами нет в базе");
            return null;
        } else {
            return souvenirsTempList.get(answer - 1);
        }

    }

@NonNull
    public ArrayList<String> returnArrayListNameSouvenir (@NonNull String nameSouvenir) {
        ArrayList<String> list = new ArrayList<>();
       new SouvenirsMethods().returnListSouvenirs().stream()
               .filter(souvenirs -> nameSouvenir.equals(souvenirs.getProductName()))
               .forEach(souvenirs ->  list.add(souvenirs.getProductName()));
       return list;
    }


}
