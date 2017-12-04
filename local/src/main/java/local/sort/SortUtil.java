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

    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSortRe(array, 0, array.length - 1);
    }

    private static void quickSortRe(int[] array, int from, int to) {
        int low = from;
        int high = to;

    }

    private static void exchange(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
