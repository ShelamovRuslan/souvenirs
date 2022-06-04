import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class TestDrive {

    public static void main(String[] args) {

        run();

/*        String[] array = new String[1000];
        Arrays.fill(array, 10);

        new TestDrive().addElement();*/
/*        HashMap<String, String> mapsID = new HashMap<>();
        mapsID.put("3970", "4970");


     String one;
        String two;
        HashMap<String, Souvenirs> map = new CatalogSouvenirs().getCatalogSouvenirs();
        ArrayList<Souvenirs> souvenirsList = new ArrayListElement().returnListSouvenirs();
        long start = System.currentTimeMillis();
        new ArrayListElement().returnListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getProductName().equals("3970"))
                .forEach(souvenirs -> System.out.println(souvenirs.getProductionYear()));
        long finish = System.currentTimeMillis();
        System.out.println("1)" + (finish - start));

        long start2 = System.currentTimeMillis();
        System.out.println(new CatalogSouvenirs().getCatalogSouvenirs().get(mapsID.get("3970")).getProductionYear());
        long finish2 = System.currentTimeMillis();
        System.out.println("2)" + (finish2 - start2));*/






    }

    public Runnable addElement() {
        for (int i = 6500; i < 100_000; i++) {
            CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
            Manufacturer manufacturer = new Manufacturer(i + "", i + "");
            catalogManufacturer.addElementCatalogManufacturer(manufacturer);
            CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
            Souvenirs souvenirs = new Souvenirs(i + "", manufacturer, i, i + "");
            catalogSouvenirs.addElementCatalogSouvenirs(souvenirs);


            System.out.println(i);

        }
        return null;
    }

    public static void run() {
        int x = 0;
        while (x < 1) {

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
                    new DeleteManufacturer().deleteManufacturer();
                    break;
                case "12":
                    new Manufacturer().addNewManufacture();
                    break;
                case "13":
                    new Editor().editeManufacture();
                    break;
                case "14":
                    x ++;
                    break;
            }
        }
    }
}
