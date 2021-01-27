package local.algorithm.nowcoder;

public class MinWindow {

    public String minWindow(String S, String T) {
        int[] countOfS = new int[128];
        int[] countOfT = new int[128];
        for (int i = 0; i < T.length(); i++) {
            countOfT[T.charAt(i)]++;
        }
        int min = Integer.MAX_VALUE, start = -1, containCount = 0;
        for (int left = 0, right = 0; right < S.length(); right++) {
            if (countOfS[S.charAt(right)] < countOfT[S.charAt(right)]) {
                containCount++;
            }
            countOfS[S.charAt(right)]++;
            while (left < right && (countOfT[S.charAt(left)] == 0 || countOfS[S.charAt(left)] > countOfT[S.charAt(left)])) {
                countOfS[S.charAt(left)]--;
                left++;
            }
            if (containCount >= T.length() && right - left + 1 < min) {
                min = right - left + 1;
                start = left;
            }
        }
        return start == -1 ? "" : S.substring(start, start + min);
    }
}
