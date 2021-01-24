package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm20210121 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int num = 0, remain = 0, sum = 0, index = A.length - 1;
        List<Integer> result = new ArrayList<>();
        while (K != 0 || index >= 0 || remain > 0) {
            num = K % 10;
            sum = remain + num;
            if (index >= 0) {
                sum += A[index--];
            }
            result.add(sum % 10);
            remain = sum / 10;
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
