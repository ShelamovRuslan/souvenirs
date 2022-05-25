import java.io.Serializable;


public class CityBike extends Product implements Serializable {

    String color;
    String model;
    int id;
    public int getId() {
        return id;
    }
    public CityBike(String color) {
        this.color = color;
        this.model = "CityBike";
        this.id = getNextId();
        this.add();
    }

}
