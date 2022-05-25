import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CatalogMonth implements Serializable {

    ArrayList<Product> catalogMonthArrayList;
    String name;
    public CatalogMonth() {
        this.catalogMonthArrayList = new ArrayList<>();
        this.name = String.valueOf(LocalDateTime.now().getMonth());
    }
    public ArrayList<Product> getCatalogMonthArrayList() {
        return catalogMonthArrayList;
    }
}
