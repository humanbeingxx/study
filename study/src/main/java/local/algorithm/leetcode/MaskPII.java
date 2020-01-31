package local.algorithm.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cuixiaoshuang
 * @date 2020-01-31
 **/
public class MaskPII {

    private static final Pattern PHONE_PATTERN
            = Pattern.compile("(\\d{0,3})(\\d{6})(\\d{4})");

    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("([a-zA-z])[a-zA-z]*([a-zA-z])(@[a-zA-z]{2,}\\.[a-zA-z]{2,})");

    public String maskPII(String S) {
        Matcher emailMatcher = EMAIL_PATTERN.matcher(S);
        if (emailMatcher.find()) {
            return processEmail(emailMatcher).toLowerCase();
        } else {
            S = S.replaceAll("[ ()+\\-]", "");
            Matcher matcher = PHONE_PATTERN.matcher(S);
            if (!matcher.find()) {
                return "";
            }
            return processPhone(matcher);
        }
    }

    private String processEmail(Matcher matcher) {
        return matcher.group(1) + "*****" + matcher.group(2) + matcher.group(3);
    }

    private String processPhone(Matcher matcher) {
        StringBuilder sb = new StringBuilder();
        String areaCode = matcher.group(1);
        if (areaCode != null && !areaCode.isEmpty()) {
            sb.append("+");
            for (int i = 0; i < areaCode.length(); i++) {
                sb.append("*");
            }
            sb.append("-");
        }
        sb.append("***-***-").append(matcher.group(3));
        return sb.toString();
    }
}
