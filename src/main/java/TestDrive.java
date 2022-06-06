import java.util.ArrayList;
import java.util.HashMap;

public class TestDrive {

    static String x = "String";

    public static void main(String[] args) {


       new Facade().startProgram();

      /*  ArrayList<Souvenirs> list = new ArrayListSouvenirs().getArrayListSouvenirs();
        long start = System.currentTimeMillis();
        list.stream().filter(souvenirs -> souvenirs.getProductName().equals("2351608"))
                .forEach(souvenirs -> System.out.println(souvenirs.getProductName()));
        long finish = System.currentTimeMillis();
        System.out.println("1) " + (finish - start));

        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        catalogSouvenirs.restore();
        long start2 = System.currentTimeMillis();
        System.out.println(catalogSouvenirs.getCatalogSouvenirs().get("2351608").getProductName());
        long finish2 = System.currentTimeMillis();
        System.out.println("2) " + (finish2 - start2));*/


/*        long start = System.currentTimeMillis();
        new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getProductName().equals("2351608"))
                .forEach(souvenirs -> System.out.println(souvenirs.getProductName()));
        long finish = System.currentTimeMillis();

        System.out.println("1) " + (finish - start));
        long start2 = System.currentTimeMillis();
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        catalogSouvenirs.restore();
        System.out.println(catalogSouvenirs.getCatalogSouvenirs().get("2351608").getProductName());
        long finish2 = System.currentTimeMillis();
        System.out.println("2) " + (finish2 - start2));*/

       /*  Facade facade = new Facade();
        facade.startProgram();

         ArrayList<Souvenirs> souvenirs = new ArrayListSouvenirs().getArrayListSouvenirs();
        new Editor().editeSouvenirs();



        System.out.println();
      run();
          String[] array = new String[1000];
        Arrays.fill(array, 10);
        new TestDrive().addElement();



     //   1) 514
    //    2) 248

        HashMap<String, Souvenirs> souvenirsHashMap = new HashMap<>();
        HashMap<String, Manufacturer> manufacturerHashMap = new HashMap<>();
        for (int i = 0; i < 3_000_000; i++) {
            Manufacturer manufacturer = new Manufacturer(i + "",i + "", i + "");
            manufacturerHashMap.put(manufacturer.getIdManufacturer(), manufacturer);
            Souvenirs souvenirs = new Souvenirs( i + "",i + "", manufacturer, i, i + "");
            souvenirsHashMap.put(souvenirs.getIdNameSouvenirs(), souvenirs);

            System.out.println(i);

        }
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        CatalogManufacturer catalogManufacturer = new CatalogManufacturer();
        catalogSouvenirs.addCatalogSouvenirs(souvenirsHashMap);
        catalogManufacturer.addCatalogManufacturer(manufacturerHashMap);*/
    }
}

