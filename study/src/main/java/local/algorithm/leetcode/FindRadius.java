package local.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 22:04
 */
public class FindRadius {

    //TODO 放弃了
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int j = 0;
        int max = -1;
        for (int i = 0; i < houses.length; i++) {
            if ((j + 1 < heaters.length) && (Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1]))) {
                j++;
                i--;
            } else {
                if (max < Math.abs(houses[i] - heaters[j])) {
                    max = Math.abs(houses[i] - heaters[j]);
                }
            }
        }
        return max;
    }
}
