package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:13
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int left = n % 26;
            sb.append((char) (left + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
