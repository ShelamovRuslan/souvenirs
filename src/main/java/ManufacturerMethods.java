import lombok.NonNull;

import java.util.ArrayList;

public class ManufacturerMethods {
    public void viewInfoAllManufacturer() {
        new ArrayListElement().returnListManufacturer().forEach(manufacturerTemp-> {
            new ProductInfo().infoManufacturer(manufacturerTemp);
            new ArrayListElement().returnListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new ProductInfo().infoProduct(souvenirs));
        });
    }
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new Console().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        manufacturerTemp = new ManufacturerMethods().returnObjectManufacturerForManufacturerName(manufacturerName);
        new SouvenirsMethods().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new ProductInfo().infoProduct(souvenirs));
    }
    public void viewAllManufacturer () {
        ArrayList<Manufacturer> listManufacturerTemp =new ArrayListElement().returnListManufacturer();
        listManufacturerTemp.forEach(manufacturer ->  new ProductInfo().infoManufacturer(manufacturer));
    }

    public ArrayList<String> returnAllManufactureName (){
        ArrayList<String> listTemp = new ArrayList<>();
        new ArrayListElement().returnListManufacturer().forEach(
                manufacturer -> listTemp.add(manufacturer.getManufacturerName())
        );
        return listTemp;
    }

    public Manufacturer returnObjectManufacturerForManufacturerName (String manufacturerName){
        Manufacturer manufacturerTemp;
        if ( new ManufacturerMethods().returnAllManufactureName().contains(manufacturerName)){
            manufacturerTemp = new ArrayListElement().returnListManufacturer().stream()
                    .filter(manufacturer -> manufacturer.getManufacturerName().equals(manufacturerName))
                    .findFirst()
                    .get();
            new ProductInfo().infoManufacturer(manufacturerTemp);
            if (new Console().yesOrNo()) {
                return manufacturerTemp;
            } else {
               return new ConcreteElement().concreteManufacturer(manufacturerName);
            }
        } else {
            System.out.println("Производителя с таким названием нет в базе");
            return null;
        }
    }



    public Manufacturer editeManufacture (@NonNull Manufacturer manufacturer){
        Console console = new Console();

     int answer = Integer.parseInt( console.in ("""
                Что именно вы желаете изменить:
                1) Название производителя
                2) Страну
                3) Все
                """));
        if (answer == 2) {
            manufacturer.setCountry(console.in("Укажите страну"));
            return manufacturer;
        } else if (answer == 1){
            manufacturer.setManufacturerName(console.in("Введите новое название"));
            return manufacturer;
        } else {
        manufacturer.setCountry(console.in("Укажите страну"));
        manufacturer.setManufacturerName(console.in("Введите новое название"));
        return manufacturer;
        }
    }




}
