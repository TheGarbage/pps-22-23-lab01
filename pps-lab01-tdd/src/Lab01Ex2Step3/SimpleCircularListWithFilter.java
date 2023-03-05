package Lab01Ex2Step3;

import lab01.tdd.SimpleCircularList;

import java.util.Optional;

public class SimpleCircularListWithFilter extends SimpleCircularList {
    public enum condition{GREATER, GREATER_OR_EQUAL, EQUAL, MINOR, MINOR_OR_EQUAL}

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
                case GREATER:
                    if(nextNumber > referenced_number)
                        return optional;
                    break;
                case GREATER_OR_EQUAL:
                    if(nextNumber >= referenced_number)
                        return optional;
                    break;
                case EQUAL:
                    if(nextNumber == referenced_number)
                        return optional;
                    break;
                case MINOR:
                    if(nextNumber < referenced_number)
                        return optional;
                    break;
                case MINOR_OR_EQUAL:
                    if(nextNumber <= referenced_number)
                        return optional;
                    break;
            }
        }
        return Optional.empty();
    }
}
