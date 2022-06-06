import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArrayListSouvenirs {
    HashMap<String, ArrayList<Souvenirs>> map;
    private ArrayList<Souvenirs> list = new ArrayList<>();

    public ArrayListSouvenirs() {
        new NewCatalogSouvenirs().restoreCatalog();
        this.map = NewCatalogSouvenirs.getCatalogSouvenirs();
        Set<String> names = this.map.keySet();
        names.forEach(name -> list.addAll(this.map.get(name)));
    }

    public ArrayList<Souvenirs> getArrayListSouvenirs() {
        return this.list;
    }
}
