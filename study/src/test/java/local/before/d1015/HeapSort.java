package local.before.d1015;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/15 上午10:55
 **/
public class HeapSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }

        buildMaxHeap(data);
        exchange(data, 0, data.length - 1);
        for (int i = 1; i < data.length; i++) {
            adjust(data, 0, data.length - 1 - i);
            exchange(data, 0, data.length - 1 - i);
        }
    }

    static void buildMaxHeap(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(data, i, data.length - 1);
        }
    }

    private static void adjust(int[] data, int from, int to) {
        for (int i = from; i <= to; ) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left > to) {
                return;
            }
            int bigChild = left;
            if (right <= to && data[left] < data[right]) {
                bigChild = right;
            }
            if (data[i] < data[bigChild]) {
                exchange(data, i, bigChild);
            }
            i = bigChild;
        }
    }

    private static void exchange(int[] data, int pos1, int pos2) {
        int temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }
}
