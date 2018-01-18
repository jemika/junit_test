import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range implements RangeInterface{

    private long startValue;
    private long endValue;
    private List<Long> valueList = new ArrayList<Long>();

    public Range (long start, long finish){
        this.startValue = start;
        this.endValue = finish;
    }

    public static void main(String[] args) {
        Range range = new Range(4,8);
         Iterator<Long> test = range.asIterator();
        System.out.println(test.next());
        System.out.println(test.next());
    }

    public boolean isBefore(Range otherRange) {
        return this.getUpperBound() < otherRange.getLowerBound();
    }

    public boolean isAfter(Range otherRange) {
        return this.getLowerBound() > otherRange.getUpperBound();
    }

    public boolean isConcurrent(Range otherRange) {
        return this.getLowerBound() >= otherRange.getLowerBound()
                && this.getLowerBound() <= otherRange.getUpperBound()
                && this.getUpperBound() >= otherRange.getLowerBound()
                && this.getUpperBound() <= otherRange.getUpperBound();
    }

    public long getLowerBound() {
        return this.startValue;
    }

    public long getUpperBound() {
        return this.endValue;
    }

    public boolean contains(long value) {
        return value <= this.endValue && value >= this.startValue;
    }

    public List<Long> asList() {
        for (long i = this.startValue; i <= this.endValue ; i++) {
            this.valueList.add(i);
        }
        return this.valueList;
    }

    public Iterator<Long> asIterator() {

        return this.asList().iterator();
    }
}
