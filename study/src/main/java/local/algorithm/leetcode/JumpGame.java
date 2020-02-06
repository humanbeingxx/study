package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    //不超时，但是也慢
//    public boolean canJump(int[] nums) {
//        Set<Integer> needReach = new HashSet<>();
//        Set<Integer> canReach = new HashSet<>();
//        needReach.add(nums.length - 1);
//        while (!needReach.isEmpty()) {
//            for (Integer reachIndex : needReach) {
//                if (reachIndex == 0) {
//                    return true;
//                }
//                for (int i = 1; i <= reachIndex; i++) {
//                    int val = nums[reachIndex - i];
//                    if (val >= i) {
//                        if (reachIndex - i == 0) {
//                            return true;
//                        } else {
//                            canReach.add(reachIndex - i);
//                        }
//                    }
//                }
//            }
//            needReach.clear();
//            needReach.addAll(canReach);
//            canReach.clear();
//        }
//        return false;
//    }

    //超时
//    public boolean canJump(int[] nums) {
//        List<Integer> needReach = new ArrayList<>();
//        List<Integer> canReach = new ArrayList<>();
//        needReach.add(nums.length - 1);
//        while (!needReach.isEmpty()) {
//            for (Integer reachIndex : needReach) {
//                if (reachIndex == 0) {
//                    return true;
//                }
//                for (int i = 1; i <= reachIndex; i++) {
//                    int val = nums[reachIndex - i];
//                    if (val >= i) {
//                        if (reachIndex - i == 0) {
//                            return true;
//                        } else {
//                            canReach.add(reachIndex - i);
//                        }
//                    }
//                }
//            }
//            needReach.clear();
//            needReach.addAll(canReach);
//            canReach.clear();
//        }
//        return false;
//    }
}
