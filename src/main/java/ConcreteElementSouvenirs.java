import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ConcreteElementSouvenirs{
      private int counter = 0;
      private final ArrayList<Souvenirs> souvenirsTempList = new ArrayList<>();
      private Souvenirs concreteSouvenir;
      private final String nameSouvenir;

    public ConcreteElementSouvenirs(@NonNull String nameSouvenir) {
        this.nameSouvenir = nameSouvenir;
        searchConcreteSouvenir ();
    }

    public Souvenirs getConcreteSouvenir() {
        return concreteSouvenir;
    }

    @Nullable
    private void searchConcreteSouvenir () {

        if (!new ArrayListNameElement().returnArrayListNameSouvenir(nameSouvenir).isEmpty()) {
            new ArrayListSouvenirs().getArrayListSouvenirs().stream()
                    .filter(souvenirs -> souvenirs.getProductName().equals(nameSouvenir))
                    .forEach(souvenirsTempList::add);
        } else {
            System.out.println("Такого сувенира нет в списке");
            this.concreteSouvenir = null;
        }

        for ( ;counter < souvenirsTempList.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new ProductInfo().infoProduct(souvenirsTempList.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        Console console = new Console();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Сувенира с таким параметрами нет в базе");
            this.concreteSouvenir = null;
        } else {
            this.concreteSouvenir = souvenirsTempList.get(answer - 1);
        }

    }
}
