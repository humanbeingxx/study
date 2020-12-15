package local.algorithm.leetcode;

public class ReformatString {

    public String reformat(String s) {
        int cCount = 0, iCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                cCount++;
            } else {
                iCount++;
            }
        }
        if (cCount != iCount && Math.abs(cCount - iCount) != 1){
            return "";
        }
        int cPos = cCount > iCount ? 0 : 1;
        int iPos = cCount > iCount ? 1 : 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                chars[iPos] = c;
                iPos += 2;
            } else {
                chars[cPos] = c;
                cPos += 2;
            }
        }
        return new String(chars);
    }
}
