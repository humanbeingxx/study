package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 17:40
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String pre = "1";
        for (int i = 1; i < n; i++) {
            pre = countPre(pre);
        }

        return pre;
    }

    String countPre(String pre) {
        StringBuilder sb = new StringBuilder();
        char currChar = pre.charAt(0);
        int currCount = 1;
        for (int i = 1; i < pre.length(); i++) {
            char c = pre.charAt(i);
            if (c != currChar) {
                sb.append(currCount);
                sb.append(currChar);
                currCount = 1;
                currChar = c;
            } else {
                currCount++;
            }
        }
        sb.append(currCount);
        sb.append(currChar);
        return sb.toString();
    }
}
