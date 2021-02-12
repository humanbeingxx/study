package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            findRec(new StringBuilder().append(i), n, k, result);
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    private void findRec(StringBuilder currNum,
                         int n,
                         int k, List<Integer> result) {
        if (currNum.length() == n) {
            result.add(Integer.parseInt(currNum.toString()));
            return;
        }
        int pre = currNum.charAt(currNum.length() - 1) - '0';
        if (pre + k <= 9) {
            currNum.append(pre + k);
            findRec(currNum, n, k, result);
            currNum.deleteCharAt(currNum.length() - 1);
        }
        if (pre - k >= 0 && pre - k != pre + k) {
            currNum.append(pre - k);
            findRec(currNum, n, k, result);
            currNum.deleteCharAt(currNum.length() - 1);
        }
    }
}
