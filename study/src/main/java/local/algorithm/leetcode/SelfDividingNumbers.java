package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean check(int num) {
        int left, origin = num;

        while (num != 0) {
            left = num % 10;
            if (left == 0) {
                return false;
            }
            if (origin % left != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
