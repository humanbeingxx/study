package local.algorithm.leetcode;

public class MinNumberOfFrogs {

    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0) {
            return 0;
        }
        if (!croakOfFrogs.startsWith("c")) {
            return -1;
        }
        int freeFrogs = 0;
        int[] waiting = new int[4];
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            switch (c) {
                case 'c':
                    if (freeFrogs > 0) {
                        freeFrogs--;
                    }
                    waiting[0]++;
                    break;
                case 'r':
                    if (waiting[0] == 0) {
                        return -1;
                    }
                    waiting[0]--;
                    waiting[1]++;
                    break;
                case 'o':
                    if (waiting[1] == 0) {
                        return -1;
                    }
                    waiting[1]--;
                    waiting[2]++;
                    break;
                case 'a':
                    if (waiting[2] == 0) {
                        return -1;
                    }
                    waiting[2]--;
                    waiting[3]++;
                    break;
                case 'k':
                    waiting[3]--;
                    freeFrogs++;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        if (waiting[0] + waiting[1] + waiting[2] + waiting[3] > 0) {
            return -1;
        }
        return freeFrogs;
    }
}
