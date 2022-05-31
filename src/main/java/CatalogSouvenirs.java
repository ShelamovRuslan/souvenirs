import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class CatalogSouvenirs extends Catalog implements Serializable {
    HashMap<String, Souvenirs> catalogSouvenirs;

    public HashMap<String, Souvenirs> getCatalogSouvenirs() {
        return catalogSouvenirs;
    }

    public CatalogSouvenirs() {
        this.setFileName("catalogsouvenirs.dat");

        if (!new File("catalogsouvenirs.dat").exists()) {
            this.catalogSouvenirs = new HashMap<>();
        } else {
            restore();
            this.catalogSouvenirs = ((CatalogSouvenirs) this.getCatalog()).getCatalogSouvenirs();
        }

    }

    public void addElementCatalogSouvenirs (Souvenirs souvenirs) {
        this.catalogSouvenirs.put(souvenirs.getProductName(), souvenirs);
    }
}
