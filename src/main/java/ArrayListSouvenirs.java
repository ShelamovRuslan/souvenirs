import java.util.ArrayList;

public class ArrayListSouvenirs {

    private ArrayList<Souvenirs> list = new ArrayList<>();

    public ArrayListSouvenirs() {
        CatalogSouvenirs catalogSouvenirsTemp = new CatalogSouvenirs();
        catalogSouvenirsTemp.restore();
        catalogSouvenirsTemp.getCatalogSouvenirs().forEach((s, souvenirs) -> this.list.add(souvenirs));
    }

    public ArrayList<Souvenirs> returnListSouvenirs() {
        return this.list;
    }
}
