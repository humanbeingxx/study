package local.algorithm.leetcode;

import java.util.regex.Pattern;

public class ValidIPAddress {

    private final Pattern ipv4Pattern = ipv4();
    private final Pattern ipv6Pattern = ipv6();

    private Pattern ipv4() {
        String num = "((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]?\\d))";
        String regexStr = String.format("(%s\\.){3}%s", num, num);
        return Pattern.compile(regexStr);
    }

    private Pattern ipv6() {
        String num = "[\\da-fA-F]{1,4}";
        String regexStr = String.format("(%s:){7}%s", num, num);
        return Pattern.compile(regexStr);
    }

    public String validIPAddress(String IP) {
        if (ipv4Pattern.matcher(IP).find()) {
            return "IPV4";
        }
        if (ipv6Pattern.matcher(IP).find()) {
            return "IPV6";
        }
        return "Neither";
    }
}
