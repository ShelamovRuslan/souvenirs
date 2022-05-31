import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalog {
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
        if (!new File(this.fileName).exists()) {
            this.setCatalog(new Catalog());
        } else {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.fileName))) {
                this.setCatalog((Catalog) stream.readObject());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
