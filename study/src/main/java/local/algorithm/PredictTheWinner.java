package local.algorithm;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int[][] diff = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i][i] = nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                diff[i][j] = Math.max(nums[i] - diff[i + 1][j], nums[j] - diff[i][j - 1]);
            }
        }
        return diff[0][nums.length - 1] >= 0;
    }

}
