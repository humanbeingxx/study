package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 1:25
 */
public class CheckAscPossibility {

    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        boolean changedNext = true;
        int changeIdx = -1;
        int changeVal = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (changed) {
                    changedNext = false;
                    break;
                }
                changeIdx = i;
                changeVal = nums[i];
                changed = true;
                nums[i] = nums[i - 1];
            }
        }
        if (changedNext) {
            return true;
        }

        nums[changeIdx] = changeVal;
        changed = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                if (changed) {
                    return false;
                }
                changed = true;
                nums[i - 1] = nums[i];
            }
        }
        return true;
    }
//
//    public boolean checkPossibility(int[] nums) {
//        if (isAsc(nums)) {
//            return true;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//            if (i == 0) {
//                nums[i] = 0;
//            } else if (i == nums.length - 1) {
//                nums[i] = Integer.MAX_VALUE;
//            } else {
//                nums[i] = nums[i - 1];
//            }
//            if (isAsc(nums)) {
//                return true;
//            }
//            nums[i] = temp;
//        }
//        return false;
//    }
//
//    private boolean isAsc(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
