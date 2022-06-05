import java.util.ArrayList;

public class ArrayListSouvenirsConcreteManufacture {


    public ArrayList<Souvenirs> returnArrayListSouvenirsConcreteManufacture (Manufacturer manufacturer){
    ArrayList<Souvenirs> arrayListSouvenirsTemp = new ArrayList<>();
    new ArrayListSouvenirs().getArrayListSouvenirs().stream()
            .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
            .forEach(arrayListSouvenirsTemp::add);
    return arrayListSouvenirsTemp;
}
}
