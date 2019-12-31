package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        String join = String.join("", S.split("-"));
        join = join.toUpperCase();
        if (K >= join.length()) {
            return join;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < join.length(); i += K) {
            sb.insert(0, join, Math.max(0, join.length() - i - K), join.length() - i).insert(0, '-');
        }
        if (sb.charAt(0) == '-') {
            return sb.substring(1);
        } else {
            return sb.toString();
        }
    }

    public String licenseKeyFormatting2(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') {
                sb.append(S.charAt(i));
            }
        }
        for (int i = sb.length() - K; i > 0; i -= K) {
            sb.insert(i, '-');
        }
        return sb.toString().toUpperCase();
    }

    public String licenseKeyFormatting3(String S, int K) {
        String newS = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        if (sb.length() == 0) {
            return "";
        }

        for (int i = newS.length() - 1; i >= 0; i -= K) {
            for (int j = 0; j < K && i - j >= 0; j++) {
                sb.append(newS.charAt(i - j));
            }
            sb.append('-');
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
