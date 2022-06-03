import lombok.NonNull;

public class Editor {
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

    public Souvenirs editeSouvenirs (@NonNull Souvenirs souvenirs){

        Console console = new Console();
        int answer = Integer.parseInt( console.in("""
                Какие именно изменения вы желаете внести?
                1) Изменить название
                2) Изменить цену
                3) Изменить год изготовления
                4) Изменить название изготовителя
                5) Изменить страну изготовителя
                """));
        if (answer == 1){
            souvenirs.setProductName(console.in("Введите имя"));
        } else if (answer == 2){
            souvenirs.setPrice(Double.parseDouble(console.in("Введите цену")));
        } else if (answer == 3){
            souvenirs.setProductionYear(console.in("Введите год"));
        } else if (answer == 4){
            souvenirs.getManufacturer().setManufacturerName(console.in("Введите название производителя"));

        } else if (answer == 5){
            souvenirs.getManufacturer().setCountry(console.in("Введите название страны"));
        }
        return souvenirs;
    }
}
