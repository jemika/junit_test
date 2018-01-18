import org.junit.jupiter.api.*;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    Range range = new Range(4,7);
    Range otherRange12 = new Range(1,2);;
    Range otherRange89 = new Range(8,9);;
    Range otherRange25 = new Range(2,5);;
    Range otherRange58 = new Range(5,8);;
    Range otherRange56 = new Range(5,6);;

    @Test
    void isBefore() {
        assertEquals(true, otherRange12.isBefore(range), "test1");
        assertEquals(false, otherRange89.isBefore(range), "test2");
        assertEquals(false, otherRange25.isBefore(range), "test3");
        assertEquals(false, otherRange58.isBefore(range), "test4");
        assertEquals(false, otherRange56.isBefore(range), "test5");
    }

    @Test
    void isAfter() {
        assertEquals(false, otherRange12.isAfter(range), "test1");
        assertEquals(true, otherRange89.isAfter(range), "test2");
        assertEquals(false, otherRange25.isAfter(range), "test3");
        assertEquals(false, otherRange58.isAfter(range), "test4");
        assertEquals(false, otherRange56.isAfter(range), "test5");
    }

    @Test
    void isConcurrent() {
        assertEquals(false, otherRange12.isConcurrent(range), "test1");
        assertEquals(false, otherRange89.isConcurrent(range), "test2");
        assertEquals(false, otherRange25.isConcurrent(range), "test3");
        assertEquals(false, otherRange58.isConcurrent(range), "test4");
        assertEquals(true, otherRange56.isConcurrent(range), "test5");
    }

    @Test
    void getLowerBound() {
        assertEquals(4, range.getLowerBound(), "test1");
        assertEquals(1, otherRange12.getLowerBound(), "test2");
        assertEquals(8, otherRange89.getLowerBound(), "test3");
        assertEquals(2, otherRange25.getLowerBound(), "test4");
        assertEquals(5, otherRange56.getLowerBound(), "test5");
        assertEquals(5, otherRange58.getLowerBound(), "test6");
    }

    @Test
    void getUpperBound() {
        assertEquals(7, range.getUpperBound(), "test1");
        assertEquals(2, otherRange12.getUpperBound(), "test2");
        assertEquals(9, otherRange89.getUpperBound(), "test3");
        assertEquals(5, otherRange25.getUpperBound(), "test4");
        assertEquals(6, otherRange56.getUpperBound(), "test5");
        assertEquals(8, otherRange58.getUpperBound(), "test6");
    }

    @Test
    void contains() {
        assertTrue(range.contains(4), "test1");
        assertTrue(range.contains(7), "test2");
        assertTrue(range.contains(5), "test3");
        assertFalse(range.contains(3), "test4");
        assertFalse(range.contains(8), "test5");
        assertFalse(range.contains(-1), "test6");
    }

    @Test
    void asList() {
        List<Long> testList = range.asList();
        assertTrue(testList.contains(range.getLowerBound()), "test1");
        assertTrue(testList.contains(range.getUpperBound()), "test2");
        assertFalse(testList.contains(range.getLowerBound() - 1), "test3");
        assertFalse(testList.contains(range.getUpperBound() + 1), "test4");
    }

    @Test
    void asIterator() {
        Iterator<Long> testIterator = range.asIterator();
        int count = 1;
        long iter = range.getLowerBound();
        for (long i = range.getLowerBound(); i < range.getUpperBound() ; i++) {
            assertTrue(testIterator.hasNext(),"test" + count++);
            assertEquals((Long) iter, testIterator.next(), "test" + count++);
            iter++;
        }
        assertTrue(testIterator.hasNext(), "test" + count++);
        assertEquals((Long) range.getUpperBound(), testIterator.next(), "test" + count++);
        assertFalse(testIterator.hasNext(), "test" + count++);
    }

}