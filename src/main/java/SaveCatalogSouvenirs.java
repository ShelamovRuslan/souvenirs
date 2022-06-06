import java.io.*;
import java.util.ArrayList;

public class SaveCatalogSouvenirs {

    private String fileName;
    private String year;
    private String month;
    private ArrayList<Souvenirs> listSouvenirs;
    private Souvenirs addSouvenirs;

    private void setAddElementCatalog (Souvenirs souvenirs) {
        this.addSouvenirs = souvenirs;
    }

    public SaveCatalogSouvenirs(Souvenirs souvenirs) {
        setAddElementCatalog(souvenirs);
    }

    public void addElementCatalog () {
      this.year = this.addSouvenirs.getProductionYear();
      this.month = this.addSouvenirs.getProductionMonth();
      this.fileName = this.year + this.month + ".dat";

      this.listSouvenirs = NewCatalogSouvenirs.getCatalogSouvenirs().get(this.year + this.month);
      this.listSouvenirs.add(this.addSouvenirs);
      snapShot();
    }


    private void snapShot () {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            stream.writeObject(this.listSouvenirs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
