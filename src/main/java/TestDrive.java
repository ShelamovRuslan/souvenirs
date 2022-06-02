public class TestDrive {

    /**
     * Создать список из элементов каталога и его подкаталогов.
     */

    public static void main(String[] args) {





for (int i = 10; i < 15; i++) {
    CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
    Manufacturer manufacturer = new Manufacturer( i + "",i + "", i + "");
    catalogManufacturer.addElementCatalogManufacturer(manufacturer);

    CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
    Souvenirs souvenirs = new Souvenirs(i + "",i + "", manufacturer, i, i + "");
    catalogSouvenirs.addElementCatalogSouvenirs(souvenirs);

}



    run();
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
                13 
                14
                """);
        Console console = new Console();
        Manufacturer manufacturer = new Manufacturer();
        String command = new Console().in("Что сделать?");
        Souvenirs souvenirs = new Souvenirs();
        switch(command) {
            case "1":
                souvenirs.add();
                break;
            case "2":

                break;
            case "3":
                manufacturer.viewAllManufacturer();
                break;
            case "4":
                souvenirs.view();
                break;
            case "5":
                new ManufacturerMethods().viewInfoAllManufacturerSouvenirs();
                break;
            case "6":
                souvenirs.country();
                break;
            case "7":
                souvenirs.price();
                break;
            case "8":
                new ManufacturerMethods().viewInfoAllManufacturer();
                break;
            case "9":

                souvenirs.viewSouvenirsYear(
                        console.in("Введите название сувенира"),
                        console.in("Укажите год производства"));
                break;
            case "10":
                souvenirs.viewAllSouvenirsGroupYear();
                break;
            case "11":
                Manufacturer manufacturerTempDelete = new Manufacturer();
                manufacturerTempDelete = manufacturerTempDelete.returnObjectManufacturerForManufacturerName(
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
            case "Закрыть":
                break;
        }
















    }
}
