package local.sort;

/**
 * @author xiaoshuang.cui
 */
public class SortUtil {

    public static void bubbleSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    exchange(array, j, j - 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] array, int from, int to) {
        for (int i = from + 1; i <= to; i++) {
            for (int j = i; j >= from + 1; j--) {
                if (array[j] < array[j - 1]) {
                    exchange(array, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSortRe(array, 0, array.length - 1);
    }

    private static void quickSortRe(int[] array, int from, int to) {
        if (from >= to) {
            return;
        }
        int low = from;
        int high = to;
        int pivot = array[from];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = pivot;
        quickSortRe(array, from, low - 1);
        quickSortRe(array, low + 1, to);
    }

    public static void exchange(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
