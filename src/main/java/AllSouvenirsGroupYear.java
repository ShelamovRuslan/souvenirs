import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSouvenirsGroupYear {

    private ArrayList<Souvenirs> list;
    private Map<String, List<Souvenirs>> mapSouvenirs;


    public AllSouvenirsGroupYear() {
        this.list = new ArrayListSouvenirs().getArrayListSouvenirs();
        this.mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenirs::getProductionYear));
    }

    public void viewAllSouvenirsGroupYear() {
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProductionYear());
            mapSouvenirs.get(s).forEach(c -> new ProductInfo().infoProduct(c));
        });
    }
}
