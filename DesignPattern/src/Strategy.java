import java.util.ArrayList;
import java.util.List;

public class Strategy {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.add(10);
        sortedList.add(12);
        sortedList.add(1);
        sortedList.add(3);
        sortedList.setSortStrategy(new QuickSort());
        sortedList.sort();
        sortedList.setSortStrategy(new MergeSort());
        sortedList.sort();
    }
}
interface SortStrategy {
    <T> void sort(List<T> items);
}
class QuickSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Quick sort");
    }
}
class MergeSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Merge sort");
    }
}
class SortedList {
    private SortStrategy strategy;
    private List<Integer> items = new ArrayList<>();
    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void add(Integer value) {
        items.add(value);
    }
    public void sort() {
        strategy.sort(items);
    }
}