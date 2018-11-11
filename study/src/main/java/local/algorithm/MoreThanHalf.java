package local.algorithm;

/**
 * 给定一个无序数组，有n个元素，找出其中的一个多数元素，多数元素出现的次数大于⌊ n/2 ⌋，注意数组中也可能不存在多数元素。
 *
 * @author xiaoshuang.cui
 * @date 2018/9/4 下午7:58
 **/
public class MoreThanHalf {

    /**
     * @return char的int表示，没有符合条件返回-1
     */
    public static int find(char[] data) {
        char candidate = data[0];
        int count = 0;

        for (char c : data) {
            if (c == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (char c : data) {
            if (c == candidate) {
                count++;
            }
        }

        if (count >= data.length / 2 + 1) {
            return candidate;
        }
        return -1;
    }
}
