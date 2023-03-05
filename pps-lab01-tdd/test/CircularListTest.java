import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.*;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;
    private final int RANDOM_ARRAY_SIZE = 3;
    private final int[] RANDOM_NUMBER_ARRAY = new int[RANDOM_ARRAY_SIZE];
    private final int FIRST_NUMBER_TO_PUSH = 2;
    private final int N_REPETITION_ASSERT = 2;

    private void initializzation (){
        circularList = new SimpleCircularList();
    }

    @Nested
    class TestSizeZero{
        @BeforeEach
        void beforeEach(){
            initializzation();
        }

        @Test
        public void testInitialSize0(){
            assertEquals(0, circularList.size());
        }

        @Test
        public void testIsInitialliEmpty(){
            assertTrue(circularList.isEmpty());
        }

        @Test
        public void testInitialNextIsEmpty(){
            assertEquals(Optional.empty(), circularList.next());
        }

        @Test
        public void testInitialPreviusIsEmpty(){
            assertEquals(Optional.empty(), circularList.previous());
        }
    }

    @Nested
    class TestAfterOnePush{
        @BeforeEach
        void beforeEach(){
            initializzation();
            circularList.add(FIRST_NUMBER_TO_PUSH);
        }

        @Test
        public void testSizeAfterPush(){
            assertEquals(1, circularList.size());
        }

        @Test
        public void testIsNotEmptyAfterPush(){
            assertFalse(circularList.isEmpty());
        }

        @Test
        public void testNextAfterPush(){
            for(int i = 0; i < N_REPETITION_ASSERT; i++)
                assertEquals(Optional.of(FIRST_NUMBER_TO_PUSH), circularList.next());
        }

        @Test
        public void testPreviusAfterPush(){
            for(int i = 0; i < N_REPETITION_ASSERT; i++)
                assertEquals(Optional.of(FIRST_NUMBER_TO_PUSH), circularList.previous());
        }

        @Test
        public void testMixNextPreviusAfterPush(){
            assertEquals(Optional.of(FIRST_NUMBER_TO_PUSH), circularList.next());
            assertEquals(Optional.of(FIRST_NUMBER_TO_PUSH), circularList.previous());
        }
    }

    @Nested
    class TestAfterMultiplePush{
        @BeforeEach
        void beforeEach(){
            initializzation();
            Random rd = new Random();
            for(int i = 0; i < RANDOM_ARRAY_SIZE; i++) {
                RANDOM_NUMBER_ARRAY[i] = rd.nextInt();
                circularList.add(RANDOM_NUMBER_ARRAY[i]);
            }
        }

        @Test
        public void testNextAfterMultiplePush(){
            for(int i = 0; i < N_REPETITION_ASSERT; i++) {
                for (int j = 1; j < RANDOM_ARRAY_SIZE; j++) {
                    assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[j]), circularList.next());
                }
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[0]), circularList.next());
            }
        }

        @Test
        public void testPreviusAfterMultiplePush(){
            for(int i = 0; i < N_REPETITION_ASSERT; i++) {
                for(int j = RANDOM_ARRAY_SIZE - 1; j > 0; j--){
                    assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[j]), circularList.previous());
                }
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[0]), circularList.previous());
            }
        }

        @Test
        public void testMixNextPreviusAfterMultiplePush(){
            if(RANDOM_ARRAY_SIZE > 1){
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[1]), circularList.next());
                assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[0]), circularList.previous());
            }
        }

        @Test
        public void testReset(){
            assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[1]), circularList.next());
            circularList.reset();
            assertEquals(Optional.of(RANDOM_NUMBER_ARRAY[RANDOM_ARRAY_SIZE-1]), circularList.previous());
        }
    }
}
