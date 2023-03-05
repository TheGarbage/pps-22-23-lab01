package Lab01Ex2Step2;
import lab01.tdd.SimpleCircularList;
import java.util.Iterator;
import java.util.Optional;

public class SimpleCircularListIterator implements CircularListIterator {
    private final SimpleCircularList simpleCircularList = new SimpleCircularList();

    @Override
    public void add(int element) {
        simpleCircularList.add(element);
    }

    @Override
    public int size() {
        return simpleCircularList.size();
    }

    @Override
    public boolean isEmpty() {
        return simpleCircularList.isEmpty();
    }

    @Override
    public Iterator<Optional<Integer>> forwardIterator() {
        return new SimpleCircularIterator(simpleCircularList);
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return new SimpleCircularIterator(simpleCircularList, true);
    }
}
