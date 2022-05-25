import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Product {
    abstract int getId ();
    public int getNextId() {
        CatalogYear catalogTemp = new CatalogYear();
        ArrayList<Product> list = catalogTemp.getCatalogYearHashMap().get(String.valueOf(LocalDateTime.now().getMonth())).getCatalogMonthArrayList();
        if (list.size() == 0){
            return 1;
        } else {
            Product product = list.get(list.size() - 1);
            return product.getId() + 1;
        }
    }
    public void add () {
        CatalogYear catalogTemp = new CatalogYear();
        catalogTemp.
        getCatalogYearHashMap().
        get(String.valueOf(LocalDateTime.now().getMonth())).
        getCatalogMonthArrayList().
        add(this);
        catalogTemp.snapShot();
    }
}
