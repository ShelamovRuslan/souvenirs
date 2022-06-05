import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

    public void addElementCatalogSouvenirs (Souvenirs souvenirsTemp) {
        restore();
        if (this.catalogSouvenirs.containsKey(souvenirsTemp.getIdNameSouvenirs())) {
            this.catalogSouvenirs.replace(souvenirsTemp.getIdNameSouvenirs(), souvenirsTemp);
        } else {
            this.catalogSouvenirs.put(souvenirsTemp.getIdNameSouvenirs(), souvenirsTemp);
        }
        save();
    }

    public void deleteManufactureSouvenirs (Manufacturer manufacturer) {
        restore();
        ArrayList<Souvenirs> list =
        new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturer);
        list.forEach(this::deleteConcreteSouvenirs);
        save();
    }
    public void deleteConcreteSouvenirs (Souvenirs souvenirs) {
        restore();
        this.catalogSouvenirs.remove(souvenirs.getIdNameSouvenirs());
        save();
    }

    public void addCatalogSouvenirs (HashMap<String, Souvenirs> map) {
        restore();
        this.catalogSouvenirs = map;
        save();
    }
}
