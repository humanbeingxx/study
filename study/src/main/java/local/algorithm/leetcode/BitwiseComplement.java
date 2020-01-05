package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:22
 */
public class BitwiseComplement {

    public int bitwiseComplement(int N) {
        int num = 1;
        while (num < N) {
            num = (num << 1) + 1;
        }
        return N ^ num;
    }
}
