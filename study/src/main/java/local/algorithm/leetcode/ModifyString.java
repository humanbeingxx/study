package local.algorithm.leetcode;

public class ModifyString {

    public String modifyString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '?') {
                char pre = i == 0 ? ' ' : stringBuilder.charAt(i - 1);
                char next = i == stringBuilder.length() - 1 ? ' ' : stringBuilder.charAt(i + 1);
                char newChar = 'a';
                while (newChar == pre || newChar == next) {
                    newChar++;
                }
                stringBuilder.setCharAt(i, newChar);
            }
        }
        return stringBuilder.toString();
    }
}
