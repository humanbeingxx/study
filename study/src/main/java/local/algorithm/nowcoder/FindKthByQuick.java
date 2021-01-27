package local.algorithm.nowcoder;

public class FindKthByQuick {

    public int findKth(int[] a, int n, int K) {
        if (K <= 0 || K > a.length) {
            return -1;
        }
        return findRec(a, 0, n - 1, K);
    }

    private int findRec(int[] a, int start, int end, int K) {
        int low = start, high = end, pivot = a[low];
        while (low < high) {
            while (low < high && a[high] <= pivot) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
            }
            while (low < high && a[low] >= pivot) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
            }
        }
        a[low] = pivot;
        int leftLen = low - start;
        if (K == leftLen + 1) {
            return pivot;
        }
        if (leftLen == 1 && K == 1) {
            return a[start];
        }
        if (K > leftLen) {
            return findRec(a, low + 1, end, K - leftLen - 1);
        } else {
            return findRec(a, start, low - 1, K);
        }
    }
}
