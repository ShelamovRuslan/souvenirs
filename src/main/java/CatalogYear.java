import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CatalogYear implements Serializable {

    HashMap<String, CatalogMonth> catalogYearHashMap;
    String name;
    public CatalogYear() {
        CatalogYear catalogYearTemp = restore();
        this.catalogYearHashMap = catalogYearTemp.getCatalogYearHashMap();
        this.name = catalogYearTemp.name;
    }
    public HashMap<String, CatalogMonth> getCatalogYearHashMap() {
        return catalogYearHashMap;
    }
    public void snapShot() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.name))) {
            stream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private CatalogYear restore() {

        if (!new File(String.format("catalog-%d-1.dat", LocalDateTime.now().getYear())).exists()) {
            this.catalogYearHashMap = new HashMap<>();
            CatalogMonth catalogMonth = new CatalogMonth();
            catalogYearHashMap.put(catalogMonth.name, catalogMonth);
            this.name = String.format("catalog-%d-1.dat", LocalDateTime.now().getYear());
            return this;
        } else {
            int counter = 1;
            while (new File(String.format("catalog-%d-%d.dat", LocalDateTime.now().getYear(), counter) ).exists()) {
                counter ++;
            }
            this.name = String.format("catalog-%d-%d.dat", LocalDateTime.now().getYear(), counter-1);
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.name))) {
                return (CatalogYear) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                this.catalogYearHashMap = new HashMap<>();
                CatalogMonth catalogMonth = new CatalogMonth();
                catalogYearHashMap.put(catalogMonth.name, catalogMonth);
                this.name = String.format("catalog-%d-%d.dat", LocalDateTime.now().getYear(), counter);
                return this;
            }
        }
    }
}
