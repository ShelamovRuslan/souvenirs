import lombok.NonNull;

public class ProductInfo {
    public void infoProduct(@NonNull Souvenirs souvenirs) {
        System.out.printf(
                """
                        
                        Название сувенира: %s
                        Год производства: %s
                        Цена сувенира: %s
                        Страна производства: %s
                        Производитель: %s
                        
                        """,
                souvenirs.getProductName(),
                souvenirs.getProductionYear(),
                souvenirs.getPrice(),
                souvenirs.getManufacturer().getCountry(),
                souvenirs.getManufacturer().getManufacturerName()
        );
    }
    public void infoManufacturer (@NonNull Manufacturer manufacturer){
        System.out.printf("""
                
                Название производителя: %s
                Страна: %s
                
                """,
                manufacturer.getManufacturerName(),
                manufacturer.getCountry()
        );
    }
}
