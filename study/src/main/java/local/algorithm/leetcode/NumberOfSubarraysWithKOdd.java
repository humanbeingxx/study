package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubarraysWithKOdd {

    public int numberOfSubarrays(int[] nums, int k) {
        List<int[]> evenCount = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (isOdd(num)) {
                int[] leftRightCount = new int[2];
                leftRightCount[0] = count;
                if (evenCount.size() > 0) {
                    evenCount.get(evenCount.size() - 1)[1] = count;
                }
                evenCount.add(leftRightCount);
                count = 0;
            } else {
                count++;
            }
        }
        if (evenCount.size() == 0 || evenCount.size() < k) {
            return 0;
        }
        evenCount.get(evenCount.size() - 1)[1] = count;
        int result = 0;
        for (int i = k - 1; i < evenCount.size(); i++) {
            int left = evenCount.get(i - k + 1)[0];
            int right = evenCount.get(i)[1];
            result += (left + 1) * (right + 1);
        }
        return result;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
