package local.before.d1026;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/26 下午9:25
 **/
public class SundaySearch {

    public static int search(char[] source, char[] sub) {
        if (source == null || sub == null) {
            return -1;
        }
        if (sub.length == 1) {
            for (int i = 0; i < source.length; i++) {
                if (source[i] == sub[0]) {
                    return i;
                }
            }
        }

        int[] shifts = calculateShifts(sub);

        for (int sourceIndex = 0; sourceIndex < source.length; ) {
            int sourceIndexOneTurn = sourceIndex;
            boolean found = true;
            for (int subIndex = 0; subIndex < sub.length; subIndex++, sourceIndexOneTurn++) {
                if (source[sourceIndexOneTurn] != sub[subIndex]) {
                    int tail = sourceIndex + sub.length;
                    if (tail >= source.length) {
                        return -1;
                    }
                    int skip = getSkip(shifts, source[tail], sub.length);
                    sourceIndex += skip;
                    found = false;
                    break;
                }
            }
            if (found) {
                return sourceIndex;
            }
        }
        return -1;
    }

    private static int getSkip(int[] shifts, char ch, int subLen) {
        int shift = shifts[ch - 'a'];
        if (shift == 0) {
            return subLen + 1;
        }
        return shift;
    }

    private static int[] calculateShifts(char[] sub) {
        int[] shifts = new int[26];

        for (int i = 0; i < sub.length; i++) {
            shifts[sub[i] - 'a'] = sub.length - i;
        }

        return shifts;
    }
}
