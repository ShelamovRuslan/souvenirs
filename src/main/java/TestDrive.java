import java.util.ArrayList;

public class TestDrive {

    /**
     * Создать список из элементов каталога и его подкаталогов.
     */

    public static void main(String[] args) {


  CatalogManufacturer dfgdfg = new CatalogManufacturer();


for (int i = 10; i < 20; i++) {
    CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
    Manufacturer manufacturer = new Manufacturer( i + "", i + "");
    catalogManufacturer.addElementCatalogManufacturer(manufacturer);

    CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
    Souvenirs souvenirs = new Souvenirs(i + "", manufacturer,  i, i + "");
    catalogSouvenirs.addElementCatalogSouvenirs(souvenirs);

}
run();
       /* new Manufacturer().addNewManufacture();
        System.out.println(new ManufacturerMethods().returnTrueIfManufactureInBase(new Manufacturer("10","10", "10")));*/


}


/*
• Добавление, редактирование и просмотр всех производителей и всех сувениров.
• Вывести информацию о сувенирах заданного производителя.
• Вывести информацию о сувенирах, произведенных в заданной стране.
• Вывести информацию о производителях, чьи цены на сувениры меньше
        заданной.
• Вывести информацию по всем производителям и, для каждого производителя вывести
        информацию о всех сувенирах, которые он производит.
• Вывести информацию о производителях заданного сувенира, произведенного в заданном году.
• Для каждого года вывести список сувениров, произведенных в этом году.
• Удалить заданного производителя и его сувениры.
*/



    public static void run() {

        System.out.println("""
                1 Добавление сувенира
                2 редактирование сувенира
                3 просмотр всех производителей
                4 просмотр всех сувениров
                5 Вывести информацию о сувенирах заданного производителя
                6 Вывести информацию о сувенирах, произведенных в заданной стране
                7 Вывести информацию о производителях, чьи цены на сувениры меньше заданной
                8 Вывести информацию по всем производителям и их сувенирам
                9 Вывести информацию о производителях заданного сувенира, произведенного в заданном году.
                10 Для каждого года вывести список сувениров, произведенных в этом году.
                11 Удалить заданного производителя и его сувениры. 
                12 Добавление нового производителя
                13 редактирование производителя
                14 Закрыть
                """);
        Console console = new Console();
        Manufacturer manufacturer = new Manufacturer();
        String command = new Console().in("Что сделать?");
        Souvenirs souvenirs = new Souvenirs();
        switch(command) {
            case "1":
                souvenirs.addNewSouvenir();
                break;
            case "2":

                break;
            case "3":
                new ManufacturerMethods().viewAllManufacturer();
                break;
            case "4":
                new SouvenirsMethods().view();
                break;
            case "5":
                new ManufacturerMethods().viewInfoAllManufacturerSouvenirs();
                break;
            case "6":
                new SouvenirsMethods().country();
                break;
            case "7":
                new SouvenirsMethods().price();
                break;
            case "8":
                new ManufacturerMethods().viewInfoAllManufacturer();
                break;
            case "9":
                ArrayList<Souvenirs> arrayListSouvenirsYear =
                new SouvenirsMethods().returnArrayListSouvenirsYear(
                        console.in("Введите название сувенира"),
                        console.in("Укажите год производства"));
                if (arrayListSouvenirsYear.size() == 0 ){
                    System.out.println("Под ваше описание ничего не подошло");
                } else {
                    System.out.println("Вот подходящие под данное описание сувениры:");
                    arrayListSouvenirsYear
                            .forEach(souvenirsTempYear -> new SouvenirsMethods().infoProduct(souvenirsTempYear));
                }
                break;
            case "10":
                new SouvenirsMethods().viewAllSouvenirsGroupYear();
                break;
            case "11":
                Manufacturer manufacturerTempDelete =
                new ManufacturerMethods().returnObjectManufacturerForManufacturerName(
                     console.in("Введите название производителя")
                );
                if (manufacturerTempDelete != null) {
                    new CatalogSouvenirs().deleteManufactureSouvenirs(manufacturerTempDelete);
                    new CatalogManufacturer().deleteManufacture(manufacturerTempDelete);
                }
                break;
            case "12":
                manufacturer.addNewManufacture(); // Планирую переделать в билдер
                break;
            case "13":
           Manufacturer manufacturerTempEdite =
                 new ManufacturerMethods()
                         .returnObjectManufacturerForManufacturerName(
                         console.in("Введите имя производителя которого желаете отредактировать"));
                if (manufacturerTempEdite != null){
                manufacturerTempEdite = new ManufacturerMethods().editeManufacture(manufacturerTempEdite);
                new CatalogManufacturer().addElementCatalogManufacturer(manufacturerTempEdite); // ВНЕСТИ ИЗМЕНЕНИЯ СРОЧНО
                } else {
                    System.out.println("По вашему запросу ничего не найдено");
                }
                break;
            case "14":
                break;
        }
















    }
}
