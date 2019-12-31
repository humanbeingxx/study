package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class ReplaceElementsWithLeftMax {

    public int[] replaceElements(int[] arr) {
        if (arr.length == 0) {
            return arr;
        } else if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int val = arr[i];
            arr[i] = max;
            max = Math.max(val, max);
        }
        return arr;
    }
}
