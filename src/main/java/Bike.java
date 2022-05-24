import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bike extends Product{
    int id;
    String color;
    String model;



}
