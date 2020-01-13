package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class NumSquares {

    public int numSquares(int n) {
        int i = 1;
        List<Integer> sqs = new ArrayList<>();
        while (n / i >= i) {
            sqs.add(i * i);
            i++;
        }
        i--;
        List<Map<String, Integer>> distance = new ArrayList<>();
        Map<String, Integer> ones = new HashMap<>();
        for (int j = 0; j < i; j++) {
            int sq = sqs.get(j);
            if (sq == n) {
                return 1;
            } else {
                ones.put(Integer.toString(j + 1), n - sq);
            }
        }
        distance.add(ones);
        for (int j = 0; j < n; j++) {
            Map<String, Integer> preDistance = distance.get(j);
            Map<String, Integer> currDistance = new HashMap<>();
            for (Map.Entry<String, Integer> entry : preDistance.entrySet()) {
                String preKey = entry.getKey();
                Integer preValue = entry.getValue();
                for (int k = 0; k < i; k++) {
                    int sq = sqs.get(k);
                    if (sq == preValue) {
                        return j + 2;
                    } else if (preValue > sq) {
                        currDistance.put(preKey + "_" + k, preValue - sq);
                    }
                }
            }
            distance.add(currDistance);
        }
        return n;
    }
}
