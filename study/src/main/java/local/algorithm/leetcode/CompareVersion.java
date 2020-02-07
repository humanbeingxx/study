package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length) {
            int seg1 = Integer.parseInt(v1[i1]);
            int seg2 = Integer.parseInt(v2[i2]);
            if (seg1 == seg2) {
                i1++;
                i2++;
            } else {
                return seg1 - seg2 > 0 ? 1 : -1;
            }
        }
        while (i1 < v1.length) {
            int seg1 = Integer.parseInt(v1[i1]);
            if (seg1 != 0) {
                return 1;
            }
            i1++;
        }
        while (i2 < v2.length) {
            int seg2 = Integer.parseInt(v2[i2]);
            if (seg2 != 0) {
                return -1;
            }
            i2++;
        }
        return 0;
    }
}
