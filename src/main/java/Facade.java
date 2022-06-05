public class Facade {

    boolean closedProgram;


    public void startProgram() {

        while (!closedProgram) {

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

            String command = new Console().in("Что сделать?");

            switch (command) {
                case "1":
                    new Souvenirs().addNewSouvenir();
                    break;
                case "2":
                    new Editor().editeSouvenirs();
                    break;
                case "3":
                    new InformerAllInfo().viewAllManufacturer();
                    break;
                case "4":
                    new InformerAllInfo().viewAllSouvenirs();
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
                    new ElementManufacturerToDelete(new Console().in("Введите название производителя"))
                            .deleteManufacturer();
                    break;
                case "12":
                    new Manufacturer().addNewManufacture();
                    break;
                case "13":
                    new Editor().editeManufacture();
                    break;
                case "14":
                    this.closedProgram = true;
                    break;
            }
        }
    }
}


