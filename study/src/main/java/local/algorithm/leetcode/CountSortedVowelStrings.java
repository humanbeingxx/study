package local.algorithm.leetcode;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int[] counts = new int[5];
        for (int i = 0; i < 5; i++) {
            counts[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int currSum = counts[0];
            for (int j = 1; j < 5; j++) {
                currSum += counts[j];
                counts[j] += currSum - counts[j];
            }
        }
        int allCount = 0;
        for (int count : counts) {
            allCount += count;
        }
        return allCount;
    }
}
