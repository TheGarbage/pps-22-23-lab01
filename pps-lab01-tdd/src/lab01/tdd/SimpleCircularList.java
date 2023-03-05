package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList{
    protected List<Integer> list = new ArrayList<>();
    private int currentElement = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return getCurrentElement(true);
    }

    @Override
    public Optional<Integer> previous() {
        return getCurrentElement(false);
    }

    private Optional<Integer> getCurrentElement(boolean next){
        if(this.list.isEmpty())
            return Optional.empty();
        if(next) {
            if(this.currentElement != (this.list.size() - 1))
                this.currentElement++;
            else
                this.currentElement = 0;
        }
        else {
            if(this.currentElement != 0)
                this.currentElement--;
            else
                this.currentElement = (this.list.size() - 1);
        }
        return Optional.of(list.get(currentElement));
    }

    @Override
    public void reset() {
        currentElement = 0;
    }
}
