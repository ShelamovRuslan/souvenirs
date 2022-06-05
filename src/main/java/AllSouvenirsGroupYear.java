import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSouvenirsGroupYear {
    public void viewAllSouvenirsGroupYear() {
        ArrayList<Souvenirs> list = new ArrayListSouvenirs().getArrayListSouvenirs();
        Map<String, List<Souvenirs>> mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenirs::getProductionYear));
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProductionYear());
            mapSouvenirs.get(s).forEach(c -> new ProductInfo().infoProduct(c));
        });
    }
}
