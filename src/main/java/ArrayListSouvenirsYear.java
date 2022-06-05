import java.util.ArrayList;

public class ArrayListSouvenirsYear {

    Console console = new Console();
 public void Method () {
    ArrayList<Souvenirs> arrayListSouvenirsYear =
            new ArrayListSouvenirsYear().returnArrayListSouvenirsYear(
                    console.in("Введите название сувенира"),
                    console.in("Укажите год производства"));
                if (arrayListSouvenirsYear.size() == 0 ){
        System.out.println("Под ваше описание ничего не подошло");
    } else {
        System.out.println("Вот подходящие под данное описание сувениры:");
        arrayListSouvenirsYear
                .forEach(souvenirsTempYear -> new ProductInfo().infoProduct(souvenirsTempYear));
    }
 }
    public ArrayList<Souvenirs> returnArrayListSouvenirsYear(String name, String year) {
        ArrayList<Souvenirs> listArrayList = new ArrayList<>();
        new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                .filter(s -> s.getProductName().equals(name))
                .filter(souvenirs -> souvenirs.getProductionYear().equals(year))
                .forEach(listArrayList::add);
        return listArrayList;
    }
}
