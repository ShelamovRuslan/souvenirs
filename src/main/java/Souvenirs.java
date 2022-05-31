import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CityBike extends Product implements Serializable {

    int id;
    

    String nameProduct;
    Manufacturer manufacturer;
    int  productionDate;
    double price;


}
