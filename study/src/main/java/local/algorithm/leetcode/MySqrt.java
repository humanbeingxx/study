package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class MySqrt {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1, high = x / 2 + 1, mid = low + (high - low) / 2;
        while (low <= high) {
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        return high;
    }
}
