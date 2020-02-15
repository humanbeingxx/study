package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-02-15
 **/
public class PredictPartyVictory {

    public String predictPartyVictory(String senate) {
        int preR = 0, preD = 0;
        StringBuilder sb = new StringBuilder(senate);
        while (true) {
            boolean win = true;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == ' ') {
                    continue;
                }
                if (c == 'R') {
                    if (preD > 0) {
                        win = false;
                        sb.setCharAt(i, ' ');
                        preD--;
                    } else {
                        preR++;
                    }
                } else {
                    if (preR > 0) {
                        win = false;
                        sb.setCharAt(i, ' ');
                        preR--;
                    } else {
                        preD++;
                    }
                }
            }
            if (win) {
                break;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'R') {
                return "Radiant";
            }
            if (sb.charAt(i) == 'D') {
                return "Dire";
            }
        }
        return "";
    }
}
