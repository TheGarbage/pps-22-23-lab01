import Lab01Ex2Step2.CircularListIterator;
import Lab01Ex2Step2.SimpleCircularListIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListIteratorTest {
    private CircularListIterator circularList;
    private final int RANDOM_ARRAY_SIZE = 3;
    private final int[] RANDOM_NUMBER_ARRAY = new int[RANDOM_ARRAY_SIZE];
    private final int N_REPETITION_ASSERT = 2;

    @BeforeEach
    void beforeEach(){
        circularList = new SimpleCircularListIterator();
        Random rd = new Random();
        for(int i = 0; i < RANDOM_ARRAY_SIZE; i++) {
            RANDOM_NUMBER_ARRAY[i] = rd.nextInt();
            circularList.add(RANDOM_NUMBER_ARRAY[i]);
        }
    }

    @Test
    public void testForwardIterator(){
        Iterator<Optional<Integer>> forwardIterator =  circularList.forwardIterator();
        for(int i = 0; i < N_REPETITION_ASSERT; i++) {
            for (int j = 1; j < RANDOM_ARRAY_SIZE; j++) {
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[j]), forwardIterator.next());
            }
            assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[0]), forwardIterator.next());
        }
    }

    @Test
    public void testBackwardIterator(){
        Iterator<Optional<Integer>> backwardIterator =  circularList.backwardIterator();
        for(int i = 0; i < N_REPETITION_ASSERT; i++) {
            for(int j = RANDOM_ARRAY_SIZE - 1; j > 0; j--){
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[j]), backwardIterator.next());
            }
            assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[0]), backwardIterator.next());
        }
    }
}
