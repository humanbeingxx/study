package local.algorithm.leetcode;

public class NumTilePossibilities {

    public int numTilePossibilities(String tiles) {
        int[] counts = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            counts[tiles.charAt(i) - 'A']++;
        }
        return rec(tiles.length(), counts);
    }

    private int rec(int left, int[] counts) {
        if (left == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                count++;
                counts[i]--;
                count += rec(left - 1, counts);
                counts[i]++;
            }
        }
        return count;
    }
}
