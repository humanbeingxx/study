package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveMinSubarrayModP {

    public int minSubarray(int[] nums, int p) {
        long currSum = 0;
        Map<Integer, List<Integer>> sumModMap = new HashMap<>();
        for (int num : nums) {
            currSum += num;
        }
        int mod = (int) (currSum % p);
        if (mod == 0) {
            return 0;
        }
        currSum = 0;
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int currMod = (int) (currSum % p);
            int needMod = (p - mod + currMod) % p;
            if (needMod == 0) {
                minLen = Math.min(minLen, i + 1);
            }
            List<Integer> sumMods = sumModMap.get(needMod);
            if (sumMods != null) {
                int currMin = i - sumMods.get(sumMods.size() - 1);
                minLen = Math.min(currMin, minLen);
            }
            sumModMap.putIfAbsent(currMod, new ArrayList<>());
            sumModMap.get(currMod).add(i);
        }
        return minLen == nums.length ? -1 : minLen;
    }

    public int minSubarrayForce(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int min = nums.length, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if ((sum - currSum) % p == 0) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == nums.length ? -1 : min;
    }
}
