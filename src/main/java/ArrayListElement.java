import java.util.ArrayList;

public class ArrayListElement {
    public ArrayList<Manufacturer> returnListManufacturer () {
        ArrayList<Manufacturer> list = new ArrayList<>();
        CatalogManufacturer catalogManufacturerTemp = new CatalogManufacturer();
        catalogManufacturerTemp.restore();
        catalogManufacturerTemp.getCatalogManufacturer().forEach((s, manufacturer) -> list.add(manufacturer));
        return list;
    }

    public ArrayList<Souvenirs> returnListSouvenirs() {
        ArrayList<Souvenirs> list = new ArrayList<>();
        CatalogSouvenirs catalogSouvenirsTemp = new CatalogSouvenirs();
        catalogSouvenirsTemp.restore();
        catalogSouvenirsTemp.getCatalogSouvenirs().forEach((s, souvenirs) -> list.add(souvenirs));
        return list;
    }
}
