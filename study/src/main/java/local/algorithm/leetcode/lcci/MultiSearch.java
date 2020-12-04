package local.algorithm.leetcode.lcci;

import java.util.*;

public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        Map<String, Integer> smallSet = new HashMap<>();
        for (int i = 0; i < smalls.length; i++) {
            smallSet.put(smalls[i], i);
        }
        List<List<Integer>> result = new ArrayList<>(smalls.length);
        for (int i = 0; i < smalls.length; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < big.length(); i++) {
            for (int j = big.length() - 1; j >= i; j--) {
                String s = big.substring(i, j);
                Integer existSmall = smallSet.get(s);
                if (existSmall != null) {
                    result.get(existSmall).add(i);
                }
            }
        }
        int[][] resultArr = new int[smalls.length][];
        for (int i = 0; i < result.size(); i++) {
            int[] oneRes = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                oneRes[j] = result.get(i).get(j);
            }
            resultArr[i] = oneRes;
        }
        return resultArr;
    }
}
