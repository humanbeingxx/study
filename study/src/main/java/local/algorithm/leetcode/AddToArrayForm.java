package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-03
 **/
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        A[A.length - 1] += K;
        int sum, remain = A[A.length - 1] / 10;
        result.add(A[A.length - 1] % 10);
        for (int i = A.length - 2; i >= 0; i--) {
            sum = A[i] + remain;
            remain = sum / 10;
            result.add(sum % 10);
        }
        while (remain > 0) {
            result.add(remain % 10);
            remain /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
