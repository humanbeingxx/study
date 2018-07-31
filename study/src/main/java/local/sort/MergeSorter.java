package local.sort;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 */
public class MergeSorter<T extends Comparable<T>> {

    private List<T> originData;

    private boolean sorted;

    public MergeSorter(List<T> originData) {
        this.originData = originData;
    }

    public void sort() {
        if (sorted || originData.size() <= 1) {
            return;
        }
        List<T> temp = Lists.newArrayListWithCapacity(originData.size());
        for (int i = 0; i < originData.size(); i++) {
            temp.add(originData.get(0));
        }

        sortREC(0, originData.size() - 1, temp);

        sorted = true;
    }

    protected void sortREC(int from, int to, List<T> temp) {
        if (from >= to) {
            return;
        }
        sortREC(from, (from + to) / 2, temp);
        sortREC((from + to) / 2 + 1, to, temp);
        merge(originData, from, (from + to) / 2, to, temp);

    }

    protected void merge(List<T> data, int from, int mid, int to, List<T> temp) {
        int index1 = from;
        int index2 = mid + 1;
        int indexTo = 0;

        while (index1 <= mid && index2 <= to) {
            if (data.get(index1).compareTo(data.get(index2)) > 0) {
                temp.set(indexTo++, data.get(index2++));
            } else {
                temp.set(indexTo++, data.get(index1++));
            }
        }

        while (index1 <= mid) {
            temp.set(indexTo++, data.get(index1++));
        }

        while (index2 <= to) {
            temp.set(indexTo++, data.get(index2++));
        }

        for (int i = 0; i < indexTo; i++) {
            data.set(from + i, temp.get(i));
        }
    }

    private void exchange(List<T> data, int index1, int index2) {
        T temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }

    public List<T> getOriginData() {
        return originData;
    }
}
