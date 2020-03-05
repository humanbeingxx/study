package local.algorithm.leetcode;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        if (diff.length == 1) {
            return diff[0] >= 0 ? 0 : -1;
        }
        int sum = 0;
        for (int i : diff) {
            sum += i;
        }
        if (sum < 0) {
            return -1;
        }
        int curr = 0;
        while (diff[curr] <= 0) {
            curr++;
        }
        sum = diff[curr];
        int next = (curr + 1) % diff.length;
        while (curr != next) {
            if (sum < 0) {
                curr = next;
                while (diff[curr] <= 0) {
                    curr++;
                }
                next = (curr + 1) % diff.length;
                sum = diff[curr];
            } else {
                sum += diff[next];
                next = (next + 1) % diff.length;
            }
        }
        return curr;
    }
}
