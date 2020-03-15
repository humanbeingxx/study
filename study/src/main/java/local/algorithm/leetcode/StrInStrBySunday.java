package local.algorithm.leetcode;

public class StrInStrBySunday {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        }
        int[] lastPos = lastPos(needle);
        int pos = 0;
        while (pos <= haystack.length() - needle.length()) {
            if (match(haystack, pos, needle)) {
                return pos;
            } else if (pos + needle.length() >= haystack.length()) {
                return -1;
            } else {
                char nextC = haystack.charAt(pos + needle.length());
                int lastPosOfC = lastPos[nextC - 'a'];
                if (lastPosOfC == 0) {
                    pos += needle.length();
                } else {
                    pos += needle.length() - lastPosOfC;
                }
            }
        }
        return -1;
    }

    private int[] lastPos(String needle) {
        int[] pos = new int[26];
        for (int i = needle.length() - 1; i >= 0; i--) {
            char c = needle.charAt(i);
            if (pos[c - 'a'] == 0) {
                pos[c - 'a'] = i;
            }
        }
        return pos;
    }

    private boolean match(String source, int start, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (source.charAt(start + i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
