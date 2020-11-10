package local.algorithm.leetcode;

public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        int missCount = 0, missNum = 1;
        int index = 0;
        while (missCount < k) {
            if (index < arr.length && arr[index] == missNum) {
                missNum++;
                index++;
            } else {
                missCount++;
                if (missCount < k) {
                    missNum++;
                }
            }
        }
        return missNum;
    }
}
