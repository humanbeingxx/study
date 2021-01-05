package local.algorithm.leetcode;

public class KthHappyString {

    static char[] alphas = new char[]{'a', 'b', 'c'};

    int count = 0;
    String result = "";

    public String getHappyString(int n, int k) {
        rec(n, k, new StringBuilder());
        return result;
    }

    private void rec(int len, int k, StringBuilder stringBuilder) {
        if (count > k) {
            return;
        }
        if (stringBuilder.length() == len) {
            count++;
            if (count == k) {
                result = stringBuilder.toString();
            }
            return;
        }
        for (char alpha : alphas) {
            if (stringBuilder.length() == 0 || stringBuilder.charAt(stringBuilder.length() - 1) != alpha) {
                stringBuilder.append(alpha);
                rec(len, k, stringBuilder);
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }
    }
}
