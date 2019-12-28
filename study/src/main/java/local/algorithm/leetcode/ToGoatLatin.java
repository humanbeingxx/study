package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class ToGoatLatin {

    public String toGoatLatin(String S) {
        String[] split = S.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = transform(split[i], i);
        }
        return String.join(" ", split);
    }

    private String transform(String s, int index) {
        char firstC = s.charAt(0);
        StringBuilder sb;
        if (firstC == 'a'
                || firstC == 'i'
                || firstC == 'u'
                || firstC == 'e'
                || firstC == 'o'
                || firstC == 'A'
                || firstC == 'I'
                || firstC == 'U'
                || firstC == 'E'
                || firstC == 'O'
        ) {
            sb = new StringBuilder(s).append("ma");
        } else {
            sb = new StringBuilder(s.substring(1)).append(firstC).append("ma");
        }
        for (int i = 0; i < index + 1; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
