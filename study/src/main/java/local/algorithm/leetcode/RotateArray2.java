package local.algorithm.leetcode;

public class RotateArray2 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int moveCount = 0;
        for (int start = 0; moveCount < nums.length; start++) {
            int pos = start;
            int preNum = nums[start];
            do {
                pos = (pos + k) % nums.length;
                int temp = nums[pos];
                nums[pos] = preNum;
                preNum = temp;
                moveCount++;
            } while (pos != start);
        }
    }
}
