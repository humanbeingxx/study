package local.algorithm.leetcode;

import java.util.Stack;

public class SumSubarrayMins {

    public int sumSubarrayMins(int[] arr) {
        int[] smallerCount = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int ans = 0, delta = 0;
        for (int j = 0; j < arr.length; ++j) {
            int count = 1;
            delta += arr[j];
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[j]) {
                Integer index = stack.pop();
                count += smallerCount[index];
                delta += (arr[j] - arr[index]) * smallerCount[index];
            }
            smallerCount[j] = count;
            stack.push(j);
            ans += delta;
            ans %= 1000000007;
        }
        return ans;
    }

    public int sumSubarrayMinsForce(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }
}
