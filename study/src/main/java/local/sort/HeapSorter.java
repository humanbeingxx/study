package local.sort;

/**
 * @author xiaoshuang.cui
 */
public class HeapSorter<T extends Comparable<? super T>> {

    public void sort(T[] data) {
        if (data.length < 2) {
            return;
        }
        makeHeap(data);
        for (int i = data.length - 1; i >= 0; i--) {
            exchange(data, 0, i);
            adjust(data, 0, i - 1);
        }
    }

    protected void makeHeap(T[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjust(data, i, data.length - 1);
        }
    }

    /**
     * index [from, to]
     */
    protected void adjust(T[] data, int from, int to) {
        for (int i = from * 2 + 1; i <= to; i = i * 2 + 1) {
            int left = i;
            int right = i + 1;
            if (right <= to && data[left].compareTo(data[right]) > 0) {
                i = right;
            }
            if (data[i].compareTo(data[(i - 1) / 2]) < 0) {
                exchange(data, i, (i - 1) / 2);
            }
        }
    }

    private void exchange(T[] data, int from, int to) {
        T temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
}
