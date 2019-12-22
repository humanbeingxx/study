package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/23 1:12
 */
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        if (str1.length() >= str2.length()) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        } else {
            return str1.substring(0, gcd(str2.length(), str1.length()));
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

//    public String gcdOfStrings(String str1, String str2) {
//        String maxPrefix = findMaxPrefix(str1, str2);
//        if (maxPrefix.length() == 0) {
//            return "";
//        }
//        while (maxPrefix.length() > 0) {
//            if (check(str1, maxPrefix) && check(str2, maxPrefix)) {
//                return maxPrefix;
//            }
//            maxPrefix = maxPrefix.substring(0, maxPrefix.length() - 1);
//        }
//        return "";
//    }
//
//    private String findMaxPrefix(String str1, String str2) {
//        int i = 0;
//        for (; i < str1.length() && i < str2.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                break;
//            }
//        }
//        return str1.substring(0, i);
//    }
//
//    boolean check(String str, String t) {
//        int i = t.length();
//        for (; i < str.length(); i += t.length()) {
//            if ((i + t.length()) > str.length()) {
//                return false;
//            }
//            if (!str.substring(i, i + t.length()).equals(t)) {
//                return false;
//            }
//        }
//        return i == str.length();
//    }
}
