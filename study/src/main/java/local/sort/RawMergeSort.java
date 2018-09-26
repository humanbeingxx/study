package local.sort;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午4:11
 **/
public class RawMergeSort {

    public static void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        int[] temp = new int[data.length];

        sortRec(data, 0, data.length - 1, temp);
    }

    private static void sortRec(int[] data, int begin, int end, int[] temp) {
        if (begin >= end) {
            return;
        }
        sortRec(data, begin, (begin + end) / 2, temp);
        sortRec(data, (begin + end) / 2 + 1, end, temp);

        merge(data, begin, (begin + end) / 2, end, temp);
    }

    private static void merge(int[] data, int begin, int mid, int end, int[] temp) {
        int index1 = begin;
        int index2 = mid + 1;
        int indexForTemp = begin;

        while (index1 <= mid && index2 <= end) {
            if (data[index1] > data[index2]) {
                temp[indexForTemp++] = data[index2++];
            } else if (data[index1] < data[index2]) {
                temp[indexForTemp++] = data[index1++];
            } else {
                temp[indexForTemp++] = data[index1++];
                temp[indexForTemp++] = data[index2++];
            }
        }

        while (index1 <= mid) {
            temp[indexForTemp++] = data[index1++];
        }

        while (index2 <= end) {
            temp[indexForTemp++] = data[index2++];
        }

        System.arraycopy(temp, begin, data, begin, end - begin + 1);
    }
}
