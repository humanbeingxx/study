package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class FreqAlphabets {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int index = s.indexOf('#');
            if (index < 0) {
                processSubString(s, sb, false);
            } else {
                processSubString(s.substring(0, index), sb, true);

            }
            if (index < 0 || index == s.length() - 1) {
                break;
            }
            s = s.substring(index + 1);
        }
        return sb.toString();
    }

    private void processSubString(String segment, StringBuilder sb, boolean exists) {
        if (!exists) {
            for (int i = 0; i < segment.length(); i++) {
                char c = (char) (segment.charAt(i) - '1' + 'a');
                sb.append(c);
            }
        } else {
            for (int i = 0; i < segment.length() - 2; i++) {
                char c = (char) (segment.charAt(i) - '1' + 'a');
                sb.append(c);
            }
            String last = segment.substring(segment.length() - 2);
            sb.append((char) (Integer.parseInt(last) - 1 + 'a'));
        }
    }
}
