package local.interview_internal_reference.byhunter;

public class MaxHeap {

    static void fixUp(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            fixDown(data, i, data.length - 1);
        }
    }

    static void fixDown(int[] data, int index, int end) {
        while (index <= end) {
            int max = data[index], maxIndex = index, left = 2 * index + 1, right = 2 * index + 2;
            if (left < data.length && data[left] > max) {
                max = data[left];
                maxIndex = left;
            }
            if (right < data.length && data[right] > max) {
                max = data[right];
                maxIndex = right;
            }
            if (index == maxIndex) {
                return;
            }
            data[maxIndex] = data[index];
            data[index] = max;
            index = maxIndex;
        }
    }

}
