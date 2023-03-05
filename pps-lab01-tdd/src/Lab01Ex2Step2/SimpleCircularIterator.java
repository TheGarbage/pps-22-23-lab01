package Lab01Ex2Step2;

import lab01.tdd.SimpleCircularList;

import java.util.Iterator;
import java.util.Optional;

public class SimpleCircularIterator implements Iterator<Optional<Integer>> {
    final boolean reverse;
    protected SimpleCircularList simpleCircularList = new SimpleCircularList();

    public SimpleCircularIterator(SimpleCircularList simpleCircularList){
        this(simpleCircularList, false);
    }

    public SimpleCircularIterator(SimpleCircularList simpleCircularList, boolean reverse){
        this.simpleCircularList = simpleCircularList;
        this.reverse = reverse;
    }

    @Override
    public boolean hasNext() {
        return !simpleCircularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return (reverse) ? simpleCircularList.previous() : simpleCircularList.next();
    }
}
