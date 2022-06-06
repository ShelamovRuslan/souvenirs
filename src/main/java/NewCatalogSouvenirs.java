import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NewCatalogSouvenirs {

    private static HashMap<String, ArrayList<Souvenirs>> catalogSouvenirs = new HashMap<>();

    private String fileName;
    private int year;
    private int month;

    private void setFileName() {
        this.fileName = year + month + ".dat";
    }

    public void restoreCatalog () {

        this.year = LocalDateTime.now().getYear();
        this.month = LocalDateTime.now().getMonthValue();


        for (; this.year > -4000; this.year--) {
            for (this.month = 12; this.month > 0; this.month--) {
                setFileName();
                restore();
            }
        }
    }



    private void restore () {
        if (!new File(this.fileName).exists()) {
            return;
        } else {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.fileName))) {
                NewCatalogSouvenirs.catalogSouvenirs.put(
                        String.valueOf(this.year),(ArrayList<Souvenirs>) stream.readObject());
                setFileName();
            } catch (IOException e) {
                System.out.printf("В файле %s ошибка", this.fileName);
                return;
            } catch (ClassNotFoundException e) {
                System.out.printf("В файле %s ошибка", this.fileName);
                return;
            }
        }
    }


    public static HashMap<String, ArrayList<Souvenirs>> getCatalogSouvenirs() {
        return catalogSouvenirs;
    }
}
