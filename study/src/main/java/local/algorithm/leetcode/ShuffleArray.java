package local.algorithm.leetcode;

public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {
        if (nums.length <= 2) {
            return nums;
        }
        int index = 1, nextPos = 1;
        while (index < 2 * n) {
            if (nums[index] < 0) {
                index++;
                nextPos = index;
                continue;
            }
            int movePos = nextPos < n ? 2 * nextPos : 2 * (nextPos - n) + 1;
            if (movePos != index) {
                swap(nums, index, movePos);
            }
            nums[movePos] = -nums[movePos];
            nextPos = movePos;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        return nums;
    }

    private void swap(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
}
