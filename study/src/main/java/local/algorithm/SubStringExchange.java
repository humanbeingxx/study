package local.algorithm;

/**
 * @author xiaoshuang.cui
 * 交换字符数组中相邻的子串
 */
public class SubStringExchange {
    /**
     *
     * @param str
     * @param from
     * @param to
     * @param separator last index of the left substring
     */
    public static void exchange(char[] str, int from, int to, int separator) {
        int lengthLeft = separator - from + 1;
        int lengthRight = to - separator;

        if (lengthLeft <= 0 || lengthRight <= 0) {
            return;
        }

        if (lengthLeft == lengthRight) {
            exchangeSameLength(str, from, separator + 1, lengthLeft);
            return;
        }

        if (lengthLeft > lengthRight) {
            exchangeSameLength(str, from, from + lengthLeft, lengthRight);
            exchange(str, from + lengthRight, to, from + lengthLeft - 1);
        } else {
            exchangeSameLength(str, from, from + lengthRight, lengthLeft);
            exchange(str, from, from + lengthRight - 1,from + lengthLeft - 1);
        }
    }



    public static void exchangeSameLength(char[] str, int start1, int start2, int length) {
        char temp;
        for (int i = 0; i < length; i++) {
            temp = str[start1];
            str[start1] = str[start2];
            str[start2] = temp;
            start1++;
            start2++;
        }
    }
}
