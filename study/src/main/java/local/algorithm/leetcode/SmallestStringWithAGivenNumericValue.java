package local.algorithm.leetcode;

public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n; i > 0; i--) {
            int remainder = 26 * i - n;
            if (remainder >= 26) {
                stringBuilder.append('a');
                k--;
            } else {
                if (remainder > 0) {
                    stringBuilder.append((char)('a' + 25 - remainder));
                }
                for (int j = 0; j < k / 26; j++) {
                    stringBuilder.append('z');
                }
                break;
            }
        }
        return stringBuilder.toString();
    }
}
