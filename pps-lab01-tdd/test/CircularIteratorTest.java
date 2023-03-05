import Lab01Ex2Step2.SimpleCircularIterator;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularIteratorTest {
    private SimpleCircularIterator circularIterator;
    private final int NUMBER_TO_PUSH = 2;

    @Test
    public void testHasNextEmptylist(){
        circularIterator = new SimpleCircularIterator(new SimpleCircularList());
        assertFalse(circularIterator.hasNext());
    }

    @Test
    public void testHasNextNoEmptyList(){
        SimpleCircularList simpleCircularList = new SimpleCircularList();
        simpleCircularList.add(NUMBER_TO_PUSH);
        circularIterator = new SimpleCircularIterator(simpleCircularList);
        assertTrue(circularIterator.hasNext());
    }
}
