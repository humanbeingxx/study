package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 15:37
 */
public class NumMovesStones {

    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = (a + b + c) - x - z;
        int min;
        if (z - y == 1 && y - x == 1) {
            min = 0;
        } else if (z - y == 2 || y - x == 2) {
            min = 1;
        } else {
            min = 2;
        }
        int max = y - x - 1 + z - y - 1;
        return new int[]{min, max};
    }
}
