import java.io.Serializable;

public class MountainBike extends Product implements Serializable {
    String color;
    String model;
    int id;
    public int getId() {
        return id;
    }
    public MountainBike(String color) {
        this.color = color;
        this.model = "MountainBike";
        this.id = getNextId();
        this.add();
    }
}
