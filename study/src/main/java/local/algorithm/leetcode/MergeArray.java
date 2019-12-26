package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/25 21:58
 */
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertPos = m + n - 1;

        m -= 1;
        n -= 1;

        while (m >= 0 || n >= 0) {
            if (n < 0) {
                nums1[insertPos--] = nums1[m--];
            } else if (m < 0) {
                nums1[insertPos--] = nums2[n--];
            } else {
                if (nums1[m] == nums2[n]) {
                    nums1[insertPos--] = nums1[m--];
                    nums1[insertPos--] = nums2[n--];
                } else if (nums1[m] > nums2[n]) {
                    nums1[insertPos--] = nums1[m--];
                } else {
                    nums1[insertPos--] = nums2[n--];
                }
            }
        }
    }
}
