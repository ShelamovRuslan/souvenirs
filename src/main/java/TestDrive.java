public class TestDrive {

    /**
     * Создать список из элементов каталога и его подкаталогов.
     */

    public static void main(String[] args) {


//  CatalogManufacturer dfgdfg = new CatalogManufacturer();


/*for (int i = 1; i < 11; i++) {
    CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
    Manufacturer manufacturer = new Manufacturer( i + "", i + "");
    catalogManufacturer.addElementCatalogManufacturer(manufacturer);

    CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
    Souvenirs souvenirs = new Souvenirs(i + "", manufacturer,  i, i + "");
    catalogSouvenirs.addElementCatalogSouvenirs(souvenirs);

}*/
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
                Souvenirs souvenirsTemp = new ConcreteElement()
                        .searchConcreteSouvenir(console.in("Введите название сувенира"));
                if (souvenirsTemp != null) {
                    souvenirsTemp = new Editor().editeSouvenirs(souvenirsTemp);
                   new CatalogSouvenirs().addElementCatalogSouvenirs(souvenirsTemp);
                }
                break;
            case "3":
                new InformerAllInfo().viewAllManufacturer();
                break;
            case "4":
                new InformerAllInfo().view();
                break;
            case "5":
                new InformerManufacturerSouvenirs().viewInfoAllManufacturerSouvenirs();
                break;
            case "6":
                new InformerCountry().country();
                break;
            case "7":
                new Price().price();
                break;
            case "8":
                new InformerAllManufacturerAndSouvenirs().viewInfoAllManufacturer();
                break;
            case "9":
                new ArrayListSouvenirsYear().Method();
                break;
            case "10":
                new AllSouvenirsGroupYear().viewAllSouvenirsGroupYear();
                break;
            case "11":
                Manufacturer manufacturerTempDelete =
                new ConcreteElement().returnObjectManufacturerForManufacturerName(
                     console.in("Введите название производителя")
                );
                if (manufacturerTempDelete != null) {
                    new CatalogSouvenirs().deleteManufactureSouvenirs(manufacturerTempDelete);
                    new CatalogManufacturer().deleteElementCatalogManufacture(manufacturerTempDelete);
                }
                break;
            case "12":
                manufacturer.addNewManufacture();
                break;
            case "13":
           Manufacturer manufacturerTempEdite =
                 new ConcreteElement()
                         .returnObjectManufacturerForManufacturerName(
                         console.in("Введите имя производителя которого желаете отредактировать"));
                if (manufacturerTempEdite != null){
                manufacturerTempEdite = new Editor().editeManufacture(manufacturerTempEdite);
                new CatalogManufacturer().addElementCatalogManufacturer(manufacturerTempEdite);
                } else {
                    break;
                }
                break;
            case "14":
                break;
        }
















    }
}
