package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                result.add(num == 0);
            } else {
                result.add(num == 2);
            }
            num = ((num << 1) + A[i]) % 5;
        }
        return result;
    }
}
