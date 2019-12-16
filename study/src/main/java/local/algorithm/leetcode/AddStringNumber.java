package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/16 20:32
 */
public class AddStringNumber {

    public String addStrings(String num1, String num2) {
        int keep = 0;
        int maxLength = Math.max(num1.length(), num2.length());
        char[] builder = new char[maxLength + 1];
        for (int i = 0; i < maxLength; i++) {
            int digit1 = i >= num1.length() ? 0 : num1.charAt(num1.length() - 1 - i) - '0';
            int digit2 = i >= num2.length() ? 0 : num2.charAt(num2.length() - 1 - i) - '0';
            int left = (digit1 + digit2 + keep) % 10;
            builder[maxLength - i] = (char) (left + '0');
            keep = (digit1 + digit2 + keep) / 10;
        }

        if (keep == 1) {
            builder[0] = '1';
        }

        if (builder[0] == 0) {
            return new String(builder).substring(1);
        } else {
            return new String(builder);
        }
    }
}
