import java.util.ArrayList;
import java.util.List;

public class ManufacturerMethods {
    public void viewInfoAllManufacturer() {
        new ManufacturerMethods().returnListManufacturer().forEach(manufacturerTemp-> {
            new ManufacturerMethods().infoManufacturer(manufacturerTemp);
            new SouvenirsMethods().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new SouvenirsMethods().infoProduct(souvenirs));
        });
    }
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new ManufacturerMethods().returnObjectManufacturerForManufacturerName(manufacturerName);
        new SouvenirsMethods().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new SouvenirsMethods().infoProduct(souvenirs));
    }
    public void viewAllManufacturer () {
        ArrayList<Manufacturer> listManufacturerTemp = new ManufacturerMethods().returnListManufacturer();
        listManufacturerTemp.forEach(manufacturer ->  new ManufacturerMethods().infoManufacturer(manufacturer));
    }

    public ArrayList<String> returnAllManufactureName (){
        ArrayList<String> listTemp = new ArrayList<>();
        returnListManufacturer().forEach(
                manufacturer -> listTemp.add(manufacturer.getManufacturerName())
        );
        return listTemp;
    }

    public Manufacturer returnObjectManufacturerForManufacturerName (String manufacturerName){
        Manufacturer manufacturerTemp;
        if ( new ManufacturerMethods().returnAllManufactureName().contains(manufacturerName)){
            manufacturerTemp = returnListManufacturer().stream()
                    .filter(manufacturer -> manufacturer.getManufacturerName().equals(manufacturerName))
                    .findFirst()
                    .get();
            infoManufacturer(manufacturerTemp);
            if (new Console().yesOrNo()) {
                return manufacturerTemp;
            } else {
               return concreteManufacturer(manufacturerName);
            }
        } else {
            System.out.println("Производителя с таким названием нет в базе");
            return null;
        }
    }

    public Manufacturer concreteManufacturer (String nameManufacturer) {
        int counter = 0;
        ArrayList<Manufacturer> listManufacturerTempConcreteManufacturer = new ArrayList<>();

        returnListManufacturer().stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().equals(nameManufacturer))
                .forEach(listManufacturerTempConcreteManufacturer::add);


        for ( ;counter < listManufacturerTempConcreteManufacturer.size(); counter++) {
                System.out.printf("%s) ", counter + 1);
                new ManufacturerMethods().infoManufacturer(listManufacturerTempConcreteManufacturer.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        Console console = new Console();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Производителя с таким параметрами нет в базе");
            return null;
        } else {
            return listManufacturerTempConcreteManufacturer.get(answer - 1);
        }
    }




    public boolean returnTrueIfManufactureInBase (Manufacturer manufacturer){
        Manufacturer manufacturerTempEquals;
        if (manufacturer != null) {
            manufacturerTempEquals = new ManufacturerMethods().returnListManufacturer().stream()
                    .filter(manufacturer::equals)
                    .findFirst().get();
            if (manufacturerTempEquals.equals(manufacturer)){

                infoManufacturer(manufacturer);
            if (new Console().yesOrNo()) {
                return true;
            } else {
                System.out.println("Производителя с такими параметрами нет в базе");
                return false;
            }
            }
        }
            System.out.println("Производителя нет в базе");
            return false;
    }


    public ArrayList<Manufacturer> returnListManufacturer () {
        ArrayList<Manufacturer> list = new ArrayList<>();
        CatalogManufacturer catalogManufacturerTemp = new CatalogManufacturer();
        catalogManufacturerTemp.restore();
        catalogManufacturerTemp.getCatalogManufacturer().forEach((s, manufacturer) -> list.add(manufacturer));
        return list;
    }

    public void infoManufacturer (Manufacturer manufacturer){
        System.out.printf("""
                
                Название производителя: %s
                Страна: %s
                
                """,
                manufacturer.getManufacturerName(),
                manufacturer.getCountry()
        );
    }
}
