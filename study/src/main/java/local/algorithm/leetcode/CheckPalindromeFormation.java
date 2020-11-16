package local.algorithm.leetcode;

public class CheckPalindromeFormation {

    public boolean checkPalindromeFormation(String a, String b) {
        int left = a.length() / 2 - 1;
        int right = a.length() % 2 == 0 ? a.length() / 2 : a.length() / 2 + 1;
        while (left >= 0 && (a.charAt(left) == a.charAt(right))) {
            left--;
            right++;
        }
        if (left < 0) {
            return true;
        }
        if (isPalin(b.substring(0, left + 1) + a.substring(left + 1))
                || isPalin(a.substring(0, right) + b.substring(right))) {
            return true;
        }
        left = b.length() / 2 - 1;
        right = b.length() % 2 == 0 ? b.length() / 2 : b.length() / 2 + 1;
        while (left >= 0 && (b.charAt(left) == b.charAt(right))) {
            left--;
            right++;
        }
        if (left < 0) {
            return true;
        }
        if (isPalin(a.substring(0, left + 1) + b.substring(left + 1))
                || isPalin(b.substring(0, right) + a.substring(right))) {
            return true;
        }
        return false;
    }

    private boolean isPalin(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
