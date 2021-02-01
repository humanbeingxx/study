package local.algorithm.nowcoder;

public class MergeSort {

    public static void sort(int[] data) {
        int step = 1;
        int[] temp = new int[data.length];
        while (step < data.length) {
            for (int i = 0; i < data.length; i += step * 2) {
                int start1 = i, end1 = i + step - 1, start2 = i + step;
                if (end1 >= data.length || start2 >= data.length) {
                    break;
                }
                int end2 = Math.min(data.length - 1, i + 2 * step - 1);
                merge(data, start1, end1, start2, end2, temp);
            }
            step *= 2;
        }
    }

    public static void merge(int[] data, int start1, int end1, int start2, int end2, int[] temp) {
        int addIndex = start1, index1 = start1, index2 = start2;
        while (index1 <= end1 && index2 <= end2) {
            if (data[index1] <= data[index2]) {
                temp[addIndex++] = data[index1++];
            } else {
                temp[addIndex++] = data[index2++];
            }
        }
        while (index1 <= end1) {
            temp[addIndex++] = data[index1++];
        }
        while (index2 <= end2) {
            temp[addIndex++] = data[index2++];
        }
        System.arraycopy(temp, start1, data, start1, end2 - start1 + 1);
    }
}
