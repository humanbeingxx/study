package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class BullAndCows {

    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            count[secret.charAt(i) - '0']++;
        }
        char[] guessChars = guess.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guessChars[i]) {
                a++;
                count[secret.charAt(i) - '0']--;
                guessChars[i] = '-';
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (guessChars[i] != '-' && count[guess.charAt(i) - '0'] > 0) {
                b++;
                count[guess.charAt(i) - '0']--;
            }
        }
        return a + "A" + b + "B";
    }
}
