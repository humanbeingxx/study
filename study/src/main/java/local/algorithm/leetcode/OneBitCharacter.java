package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class OneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length; i++) {
            int bit = bits[i];
            if (bit != 0) {
                i++;
            } else if (i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }
}
