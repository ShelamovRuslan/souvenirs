
public class TestDrive {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.startProgram();

    /*    run();
          String[] array = new String[1000];
        Arrays.fill(array, 10);
        new TestDrive().addElement();
        long start = System.currentTimeMillis();
        new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getProductName().equals("3970"))
                .forEach(souvenirs -> System.out.println(souvenirs.getProductName()));
        long finish = System.currentTimeMillis();
        System.out.println("1) " + (finish - start));
        long start2 = System.currentTimeMillis();
        CatalogSouvenirs catalogSouvenirs = new CatalogSouvenirs();
        catalogSouvenirs.restore();
        System.out.println(catalogSouvenirs.getCatalogSouvenirs().get("99_999_999").getProductName());
        long finish2 = System.currentTimeMillis();
        System.out.println("2) " + (finish2 - start2));


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

