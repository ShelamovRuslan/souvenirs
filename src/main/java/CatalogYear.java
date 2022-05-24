import java.util.HashMap;

public class CatalogYear {

    HashMap<String, CatalogMonth> catalogYearHashMap;

    public CatalogYear() {
        this.catalogYearHashMap = new HashMap<>();
    }

    public HashMap<String, CatalogMonth> getCatalogYearHashMap() {
        return catalogYearHashMap;
    }
}
