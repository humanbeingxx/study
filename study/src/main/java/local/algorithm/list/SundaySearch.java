package local.algorithm.list;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/9/2 下午5:40
 **/
public class SundaySearch {

    /**
     * search str in target
     */
    public static int search(String target, String str) {
        int targetLen = target.length();
        int strLen = str.length();
        if (targetLen == 0 || strLen == 0) {
            return -1;
        }

        int[] shift = prepareShift(str);

        for (int i = 0; i < targetLen; ) {
            boolean search = true;
            int inner = i;
            for (int j = 0; j < strLen; j++, inner++) {

                if (target.charAt(inner) != str.charAt(j)) {
                    int tail = i + strLen;
                    if (tail > targetLen) {
                        return -1;
                    }
                    i += getShift(target.charAt(tail), shift, strLen);
                    search = false;
                    break;
                }
            }
            if (search) {
                return i;
            }
        }

        return -1;
    }

    protected static int[] prepareShift(String str) {
        char[] chars = str.toCharArray();

        int[] shifts = new int[26];
        for (int i = 0; i < 26; i++) {
            shifts[i] = -1;
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (shifts[c - 'a'] == -1) {
                shifts[c - 'a'] = chars.length - i;
            }
        }

        return shifts;
    }

    private static int getShift(char c, int[] shifts, int len) {
        if (shifts[c - 'a'] < 0) {
            return len + 1;
        }
        return shifts[c - 'a'];
    }
}
