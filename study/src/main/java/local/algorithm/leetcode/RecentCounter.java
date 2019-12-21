package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 22:14
 */
public class RecentCounter {

    int pos = 0;
    int[] happened = new int[10000];

    public int ping(int t) {
        happened[pos] = t;
        int count = 0;
        for (int i = pos; i >= 0; i--) {
            if (happened[i] < t - 3000) {
                break;
            }
            count++;
        }
        pos++;
        return count;
    }
}
