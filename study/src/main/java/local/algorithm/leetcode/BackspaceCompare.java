package local.algorithm.leetcode;

public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sbS = toSb(S);
        StringBuilder sbT = toSb(T);
        if (sbS.length() != sbT.length()) {
            return false;
        }
        for (int i = 0; i < sbS.length(); i++) {
            if (sbS.charAt(i) != sbT.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder toSb(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb;
    }
}
