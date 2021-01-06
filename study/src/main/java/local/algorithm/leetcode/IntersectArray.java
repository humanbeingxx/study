package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class IntersectArray {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        Map<Integer, Integer> intersection = new HashMap<>();
        for (int i : nums1) {
            if (count1.containsKey(i)) {
                count1.put(i, count1.get(i) + 1);
            } else {
                count1.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (count2.containsKey(i)) {
                count2.put(i, count2.get(i) + 1);
            } else {
                count2.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry1 : count1.entrySet()) {
            Integer value2 = count2.get(entry1.getKey());
            if (value2 != null) {
                intersection.put(entry1.getKey(), Math.min(entry1.getValue(), value2));
            }
        }

        int len = 0, index = 0;
        for (Integer value : intersection.values()) {
            len += value;
        }
        int[] result = new int[len];
        for (Map.Entry<Integer, Integer> entry : intersection.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[index++] = entry.getKey();
            }
        }

        return result;
    }

    public int[] intersectSorted(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
}