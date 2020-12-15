package local.algorithm.leetcode;

public class RepeatedStringMatch2 {

    public int repeatedStringMatch(String a, String b) {
        int repeat = b.length() % a.length() == 0 ? b.length() / a.length() : b.length() / a.length() + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            stringBuilder.append(a);
        }
        if (stringBuilder.toString().contains(b)) {
            return repeat;
        }
        stringBuilder.append(a);
        if (stringBuilder.toString().contains(b)) {
            return repeat + 1;
        }
        return -1;
    }
}

