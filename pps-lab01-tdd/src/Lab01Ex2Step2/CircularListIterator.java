package Lab01Ex2Step2;

import lab01.tdd.CircularListMain;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListIterator extends CircularListMain {
    /**
     * Provides a new java.util.Iterator which yields next elements, circulary.
     * @return a new java.util.Iterator
     */
    Iterator<Optional<Integer>> forwardIterator();

    /**
     * Provides a new java.util.Iterator which yields previus elements, circulary.
     * @return a new java.util.Iterator
     */
    Iterator<Optional<Integer>> backwardIterator();
}
