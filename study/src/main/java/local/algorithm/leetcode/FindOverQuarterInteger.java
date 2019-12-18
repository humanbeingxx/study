package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class FindOverQuarterInteger {

    public int findSpecialInteger(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int quarter = 0;
        if (arr.length % 4 != 0) {
            quarter = arr.length / 4 + 1;
        } else {
            quarter = arr.length / 4;
        }
        int times = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                times++;
            } else {
                if (times > quarter) {
                    return arr[i - 1];
                }
                times = 1;
            }
        }
        return arr[arr.length - 1];
    }
}
