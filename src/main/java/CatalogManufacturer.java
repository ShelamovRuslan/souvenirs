import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class CatalogManufacturer extends Catalog implements Serializable {
     HashMap<String, Manufacturer> catalogManufacturer;
    public HashMap<String, Manufacturer> getCatalogManufacturer() {
        return catalogManufacturer;
    }

    public CatalogManufacturer() {
        this.setFileName("catalogmanufacturer.dat");

        if (!new File("catalogmanufacturer.dat").exists()) {
            this.catalogManufacturer = new HashMap<>();
        } else {
            restore();
            this.catalogManufacturer = ((CatalogManufacturer) this.getCatalog()).getCatalogManufacturer();
        }
    }

    public void addElementCatalogManufacturer (Manufacturer manufacturer) {
        restore();
        if (this.catalogManufacturer.containsKey(manufacturer.getIdManufacturer())) {
            this.catalogManufacturer.replace(manufacturer.getIdManufacturer(), manufacturer);
        } else {
            this.catalogManufacturer.put(manufacturer.getIdManufacturer(), manufacturer);
        }
        save();
    }

    public void deleteElementCatalogManufacture(Manufacturer manufacturer) {
      restore();
      this.catalogManufacturer.remove(manufacturer.getIdManufacturer());
      save();
    }

    public void addCatalogManufacturer (HashMap<String, Manufacturer> map) {
        restore();
        this.catalogManufacturer = map;
        save();
    }
}
