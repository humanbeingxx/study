package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindComplement {

    public int findComplement(int num) {
        int temp = num, c = 0;
        while (temp > 0) {
            temp >>= 1;
            c = (c << 1) + 1;
        }
        return num ^ c;
    }
}
