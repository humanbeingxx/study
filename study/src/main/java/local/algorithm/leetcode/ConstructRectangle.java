package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) {
            sqrt--;
        }
        return new int[]{area / sqrt, sqrt};
    }
}
