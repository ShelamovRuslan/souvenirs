import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;


public class Manufacturer implements Serializable {

    private String idManufacturer;
    private String manufacturerName;
    private String country;

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public Manufacturer () {

    }

    public String add () {
        CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
        catalogManufacturer.restore();
        Console console = new Console();
        if (this.manufacturerName == null || this.manufacturerName.equals("")){
            this.manufacturerName = console.in("Введите название производителя");
        }
        this.country = console.in("Введите страну производителя");
        this.idManufacturer = manufacturerName.toLowerCase() + country.toLowerCase();
        catalogManufacturer.getCatalogManufacturer().put(this.idManufacturer ,this);
        catalogManufacturer.save();
        return this.idManufacturer;
    }

    public void edit () {

    }

    public void view () {

    }


    public String check(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        if(!returnListManufacturer().stream().filter(s -> s.getManufacturerName().equals(manufacturerName)).toList().isEmpty()) {
            Console console = new Console();
            String str = console.in("""
                    Вы желаете указать этого производителя?
                    Да
                    Нет
                    """);
            if (Objects.equals(str, "Да")){
                return returnListManufacturer().stream().filter(s -> s.getManufacturerName().equals(manufacturerName)).findFirst().get().getIdManufacturer();
            } else {
                add();
                return this.idManufacturer;
            }

        } else {
            add();
            return this.idManufacturer;
        }
    }
    public ArrayList<Manufacturer> returnListManufacturer () {
        ArrayList<Manufacturer> list = new ArrayList<>();
        CatalogManufacturer catalogManufacturerTemp = new CatalogManufacturer();
        catalogManufacturerTemp.restore();
        catalogManufacturerTemp.getCatalogManufacturer().forEach((s, manufacturer) -> list.add(manufacturer));
        return list;
    }
}
