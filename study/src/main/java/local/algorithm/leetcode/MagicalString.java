package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class MagicalString {

    public int magicalString(int n) {
        if (n <= 1) {
            return n;
        }
        int index = 2;
        StringBuilder sb = new StringBuilder("122");
        while (sb.length() < n) {
            for (int i = 0; i < sb.charAt(index) - '0'; i++) {
                sb.append('1');
            }
            index++;
            for (int i = 0; i < sb.charAt(index) - '0'; i++) {
                sb.append('2');
            }
            index++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
