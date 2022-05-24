import java.util.ArrayList;
import java.util.HashMap;

public class Product {



public void add () {
    CatalogMonth catalogMonth = new CatalogMonth();
    CatalogYear catalogYear = new CatalogYear();
    HashMap hashMapCatalog = catalogYear.getCatalogYearHashMap();
    catalogMonth.catalogMonthArrayList.add(Bike.builder().build());
    hashMapCatalog.put(catalogMonth.name, catalogMonth);
    System.out.println();
}


}
