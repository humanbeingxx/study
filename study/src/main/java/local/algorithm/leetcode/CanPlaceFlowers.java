package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) {
                continue;
            }
            boolean left = true, right = true;
            if (i - 1 >= 0 && flowerbed[i - 1] != 0) {
                left = false;
            }
            if (i + 1 < flowerbed.length && flowerbed[i+1] != 0) {
                right = false;
            }
            if (left && right) {
                count++;
                i++;
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}
