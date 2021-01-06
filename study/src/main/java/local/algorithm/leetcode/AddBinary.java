package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:25
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int idxA = a.length() - 1, idxB = b.length() - 1;
        char forward = '0';
        StringBuilder sb = new StringBuilder();
        while (idxA >= 0 && idxB >= 0) {
            char ca = a.charAt(idxA--);
            char cb = b.charAt(idxB--);
            if (ca == '0' && cb == '0') {
                sb.append(forward);
                forward = '0';
            } else if (ca == '1' && cb == '1') {
                sb.append(forward);
                forward = '1';
            } else {
                if (forward == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                    forward = '1';
                }
            }
        }
        while (idxA >= 0) {
            char ca = a.charAt(idxA--);
            if (ca == '0') {
                sb.append(forward);
                forward = '0';
            } else {
                if (forward == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                    forward = '1';
                }
            }
        }

        while (idxB >= 0) {
            char cb = b.charAt(idxB--);
            if (cb == '0') {
                sb.append(forward);
                forward = '0';
            } else {
                if (forward == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                    forward = '1';
                }
            }
        }

        if (forward == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
