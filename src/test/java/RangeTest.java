import org.junit.jupiter.api.*;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    private Range range = new Range(4,7);
    private Range otherRange12 = new Range(1,2);
    private Range otherRange89 = new Range(8,9);
    private Range otherRange25 = new Range(2,5);
    private Range otherRange58 = new Range(5,8);
    private Range otherRange56 = new Range(5,6);

    @Test
    void isBefore() {
        assertTrue(otherRange12.isBefore(range));
        assertFalse(otherRange89.isBefore(range));
        assertFalse(otherRange25.isBefore(range));
        assertFalse(otherRange58.isBefore(range));
        assertFalse(otherRange56.isBefore(range));
    }

    @Test
    void isAfter() {
        assertFalse(otherRange12.isAfter(range));
        assertTrue(otherRange89.isAfter(range));
        assertFalse(otherRange25.isAfter(range));
        assertFalse(otherRange58.isAfter(range));
        assertFalse(otherRange56.isAfter(range));
    }

    @Test
    void isConcurrent() {
        assertFalse(otherRange12.isConcurrent(range));
        assertFalse(otherRange89.isConcurrent(range));
        assertTrue(otherRange25.isConcurrent(range));
        assertTrue(otherRange58.isConcurrent(range));
        assertTrue(otherRange56.isConcurrent(range));
    }

    @Test
    void getLowerBound() {
        assertEquals(4, range.getLowerBound());
        assertEquals(1, otherRange12.getLowerBound());
        assertEquals(8, otherRange89.getLowerBound());
        assertEquals(2, otherRange25.getLowerBound());
        assertEquals(5, otherRange56.getLowerBound());
        assertEquals(5, otherRange58.getLowerBound());
    }

    @Test
    void getUpperBound() {
        assertEquals(7, range.getUpperBound());
        assertEquals(2, otherRange12.getUpperBound());
        assertEquals(9, otherRange89.getUpperBound());
        assertEquals(5, otherRange25.getUpperBound());
        assertEquals(6, otherRange56.getUpperBound());
        assertEquals(8, otherRange58.getUpperBound());
    }

    @Test
    void contains() {
        assertTrue(range.contains(4));
        assertTrue(range.contains(7));
        assertTrue(range.contains(5));
        assertFalse(range.contains(3));
        assertFalse(range.contains(8));
        assertFalse(range.contains(-1));
    }

    @Test
    void asList() {
        List<Long> testList = range.asList();
        assertTrue(testList.contains(range.getLowerBound()));
        assertTrue(testList.contains(range.getUpperBound()));
        assertFalse(testList.contains(range.getLowerBound() - 1));
        assertFalse(testList.contains(range.getUpperBound() + 1));
    }

    @Test
    void asIterator() {
        Iterator<Long> testIterator = range.asIterator();
        for (long i = range.getLowerBound() ;i <= range.getUpperBound() ; i++) {
            assertTrue(testIterator.hasNext());
            assertEquals((Long)i, testIterator.next());
        }
        assertFalse(testIterator.hasNext());
    }

}