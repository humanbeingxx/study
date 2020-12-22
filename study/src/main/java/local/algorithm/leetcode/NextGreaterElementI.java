package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (nums2[i] > peek) {
                    next.put(peek, nums2[i]);
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer nextG = next.get(nums1[i]);
            result[i] = nextG == null ? -1 : nextG;
        }
        return result;
    }
}
