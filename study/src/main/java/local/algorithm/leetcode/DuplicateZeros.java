package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int addCount = countAdd0(arr);
        if (addCount == 0) {
            return;
        }
        for (int i = arr.length - addCount - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[i + addCount] = arr[i];
            } else {
                arr[i + addCount] = 0;
                arr[i + addCount - 1] = 0;
                addCount--;
            }
            if (addCount == 0) {
                break;
            }
        }
    }

    int countAdd0(int[] arr) {
        int addCount = 0;
        for (int i = 0; i < arr.length - addCount - 1; i++) {
            if (arr[i] == 0) {
                addCount++;
            }
        }
        return addCount;
    }
}
