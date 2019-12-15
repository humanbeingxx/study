package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 14:39
 */
public class CalculateFraction {

    public static int[] fraction(int[] cont) {
        int up = 1, down = cont[cont.length - 1];
        int temp = 0;
        for (int i = cont.length - 2; i >= 1; i--) {
            if (cont[i] != 0) {
                up = cont[i] * down + up;
            }
            temp = up;
            up = down;
            down = temp;
        }

        up = cont[0] * down + up;

        return new int[]{up, down};
    }
}
