package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 21:30
 */
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }

        Map<Integer, Integer> leftMap = new HashMap<>();

        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int left = (60 - time[i]) % 60;

            if (leftMap.get(left) != null) {
                count += leftMap.get(left);
            }

            if (leftMap.get(time[i]) == null) {
                leftMap.put(time[i], 1);
            } else {
                leftMap.put(time[i], leftMap.get(time[i]) + 1);
            }
        }

        return count;
    }
}
