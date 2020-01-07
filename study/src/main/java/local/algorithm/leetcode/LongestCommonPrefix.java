package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char commonC = 0;
        int index = 0;
        boolean forward = true;
        while (true) {
            for (String str : strs) {
                if (index == str.length()) {
                    forward = false;
                    break;
                }
                if (commonC == 0) {
                    commonC = str.charAt(index);
                } else {
                    if (str.charAt(index) != commonC) {
                        forward = false;
                        break;
                    }
                }
            }
            if (!forward) {
                break;
            }
            sb.append(commonC);
            commonC = 0;
            index++;
        }
        return sb.toString();
    }
}
