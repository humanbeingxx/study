package local.algorithm.nowcoder;

public class MyQuickSort {

    public static void sort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        sortRec(data, 0, data.length - 1);
    }

    private static void sortRec(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start, high = end, pivot = data[start];
        while (low < high) {
            while (low < high && data[high] >= pivot) {
                high--;
            }
            if (low < high) {
                data[low] = data[high];
            }
            while (low < high && data[low] <= pivot) {
                low++;
            }
            if (low < high) {
                data[high] = data[low];
            }
        }
        data[low] = pivot;
        sortRec(data, start, low - 1);
        sortRec(data, low + 1, end);
    }
}
