import java.util.ArrayList;

public class ArrayListManufacturer {

    private ArrayList<Manufacturer> list = new ArrayList<>();

    public ArrayListManufacturer() {
        CatalogManufacturer catalogManufacturerTemp = new CatalogManufacturer();
        catalogManufacturerTemp.restore();
        catalogManufacturerTemp.getCatalogManufacturer().forEach((s, manufacturer) -> this.list.add(manufacturer));
    }

    public ArrayList<Manufacturer> getArrayListManufacturer () {

        return this.list;
    }


}
