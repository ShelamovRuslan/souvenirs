import java.util.ArrayList;

public class DeleteElementSouvenire {

    public void deleteManufactureSouvenirs (Manufacturer manufacturer) {
        ArrayList<Souvenirs> list =
                new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturer);
        list.forEach(this::deleteConcreteSouvenirs);
        save();
    }
}
