package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    sum += i;
                } else {
                    sum += (i + num / i);
                }
            }
        }
        return sum == num;
    }
}
