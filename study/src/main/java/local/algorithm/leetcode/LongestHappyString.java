package local.algorithm.leetcode;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        int[] usable = new int[]{a, b, c};
        StringBuilder stringBuilder = new StringBuilder();
        int previous = -1, sameCount = 0;
        while (usable[0] > 0 || usable[1] > 0 || usable[2] > 0) {
            int next;
            if (sameCount == 2) {
                next = decideNext(usable, previous);
            } else {
                next = decideNext(usable, -1);
            }
            if (next == -1) {
                break;
            }
            stringBuilder.append((char) ('a' + next));
            usable[next]--;
            if (previous == -1) {
                sameCount = 1;
                previous = next;
            } else if (next == previous) {
                sameCount++;
            } else {
                previous = next;
                sameCount = 1;
            }
        }
        return stringBuilder.toString();
    }

    private int decideNext(int[] usable, int unusable) {
        int max = 0, index = -1;
        for (int i = 0; i < usable.length; i++) {
            int oneUsable = usable[i];
            if (i != unusable && oneUsable > max) {
                max = oneUsable;
                index = i;
            }
        }
        return index;
    }
}
