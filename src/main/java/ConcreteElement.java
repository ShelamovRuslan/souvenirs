import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ConcreteElement {

    public Manufacturer concreteManufacturer (String nameManufacturer) {
        int counter = 0;
        ArrayList<Manufacturer> listManufacturerTempConcreteManufacturer = new ArrayList<>();

        new ArrayListElement().returnListManufacturer().stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().equals(nameManufacturer))
                .forEach(listManufacturerTempConcreteManufacturer::add);


        for ( ;counter < listManufacturerTempConcreteManufacturer.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new ProductInfo().infoManufacturer(listManufacturerTempConcreteManufacturer.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        Console console = new Console();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Производителя с таким параметрами нет в базе");
            return null;
        } else {
            return listManufacturerTempConcreteManufacturer.get(answer - 1);
        }
    }

    @Nullable
    public Souvenirs searchConcreteSouvenir (@NonNull String nameSouvenir) {
        int counter = 0;
        ArrayList<Souvenirs> souvenirsTempList = new ArrayList<>();
        if (!new SouvenirsMethods().returnArrayListNameSouvenir(nameSouvenir).isEmpty()) {
            new ArrayListElement().returnListSouvenirs().stream()
                    .filter(souvenirs -> souvenirs.getProductName().equals(nameSouvenir))
                    .forEach(souvenirsTempList::add);
        } else {
            System.out.println("Такого сувенира нет в списке");
            return null;
        }

        for ( ;counter < souvenirsTempList.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new ProductInfo().infoProduct(souvenirsTempList.get(counter));
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
}
