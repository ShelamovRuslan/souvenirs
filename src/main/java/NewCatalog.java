import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewCatalog {
    private Catalog catalog;
    private String fileName;
    protected void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Catalog getCatalog() {
        return catalog;
    }
    private void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
    public boolean save () {
        snapShot();
        return !new File(fileName).exists();
    }
    public void restore () {
        rest();
    }
    private void snapShot () {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            stream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void rest () {

    }
}
