package Lab01Ex2Step3;

import lab01.tdd.SimpleCircularList;

import javax.print.DocFlavor;
import java.util.Optional;

public class SimpleCircularListWithFilter extends SimpleCircularList {
    public enum condition{MAGGIORE, MAGGIORE_UGUALE, UGUALE, MINORE, MINORE_UGUALE}

    public Optional<Integer> filteredNext(condition condition, int referenced_number) {
        Optional<Integer> optional;
        for(int i = 0; i < list.size(); i++) {
            optional = next();
            int nextNumber;
            if(optional.isPresent())
              nextNumber = optional.get();
            else
                break;
            switch (condition) {
                case MAGGIORE:
                    if(nextNumber > referenced_number)
                        return optional;
                    break;
                case MAGGIORE_UGUALE:
                    if(nextNumber >= referenced_number)
                        return optional;
                    break;
                case UGUALE:
                    if(nextNumber == referenced_number)
                        return optional;
                    break;
                case MINORE:
                    if(nextNumber < referenced_number)
                        return optional;
                    break;
                case MINORE_UGUALE:
                    if(nextNumber <= referenced_number)
                        return optional;
                    break;
            }
        }
        return Optional.empty();
    }
}
