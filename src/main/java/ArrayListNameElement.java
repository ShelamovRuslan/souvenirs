import lombok.NonNull;

import java.util.ArrayList;

public class ArrayListNameElement {

    @NonNull
    public ArrayList<String> returnArrayListNameSouvenir (@NonNull String nameSouvenir) {
        ArrayList<String> list = new ArrayList<>();
        new ArrayListSouvenirs().returnListSouvenirs().stream()
                .filter(souvenirs -> nameSouvenir.equals(souvenirs.getProductName()))
                .forEach(souvenirs ->  list.add(souvenirs.getProductName()));
        return list;
    }

    public ArrayList<String> returnAllManufactureName (){
        ArrayList<String> listTemp = new ArrayList<>();
        new ArrayListManufacturer().returnListManufacturer().forEach(
                manufacturer -> listTemp.add(manufacturer.getManufacturerName())
        );
        return listTemp;
    }
}
