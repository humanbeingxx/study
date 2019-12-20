package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class DecimalToHex {

    public String toHex(int num) {
        String template = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 && num != 0; i++) {
            sb.insert(0, template.charAt(num & 0b1111));
            num >>= 4;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
