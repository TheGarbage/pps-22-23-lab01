import Lab01Ex2Step3.SimpleCircularListWithFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularListWithFilterTest extends CircularIteratorTest{
    SimpleCircularListWithFilter simpleCircularListWithFilter;
    private final int[] ARRAY_TEST = {1,2,3,4,5,6,7,8};
    private final int REFERED_RIGHT_NUMBER = 4;
    private final int REFERED_WRONG_NUMBER = -1;

    public void initializzation(){
        simpleCircularListWithFilter = new SimpleCircularListWithFilter();
    }

    @Nested
    class TestFilterEmpty {
        @BeforeEach
        public void beforeEach() {
            initializzation();
        }

        @Test
        public void testFilterEmpty() {
            assertEquals(Optional.empty(), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.GREATER, REFERED_RIGHT_NUMBER));
        }

    }

    @Nested
    class TestFilterAfterMultiplePush{
        @BeforeEach
        public void beforeEach() {
            initializzation();
            for(int number : ARRAY_TEST)
                simpleCircularListWithFilter.add(number);
        }

        @Test
        public void testRightGreaterOrEqualFilterAfterMultiplePush(){
            assertEquals(Optional.of(5), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.GREATER, REFERED_RIGHT_NUMBER));
        }

        @Test
        public void testRightGreaterFilterAfterMultiplePush(){
            assertEquals(Optional.of(4), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.GREATER_OR_EQUAL, REFERED_RIGHT_NUMBER));
        }

        @Test
        public void testRightEqualFilterAfterMultiplePush(){
            assertEquals(Optional.of(4), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.EQUAL, REFERED_RIGHT_NUMBER));
        }

        @Test
        public void testRightMinorOrEqualFilterAfterMultiplePush(){
            assertEquals(Optional.of(2), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.MINOR_OR_EQUAL, REFERED_RIGHT_NUMBER));
        }

        @Test
        public void testRightMinorFilterAfterMultiplePush(){
            assertEquals(Optional.of(2), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.MINOR, REFERED_RIGHT_NUMBER));
        }

        @Test
        public void testWrongFilterAfterMultiplePush(){
            assertEquals(Optional.empty(), simpleCircularListWithFilter.filteredNext(SimpleCircularListWithFilter.condition.MINOR, REFERED_WRONG_NUMBER));
        }
    }
}
