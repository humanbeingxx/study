package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class ReverseSentence {

    public String reverseWords(String s) {
        String[] split = new StringBuilder(s.trim()).reverse().toString().split(" +");
        StringBuilder sb = new StringBuilder();
        for (String sp : split) {
            sb.append(new StringBuilder(sp).reverse()).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
