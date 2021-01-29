package local.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class ConvertToIP {

    public List<List<String>> convertToIP(String num) {
        List<List<String>> result = new ArrayList<>();
        convertRec(num, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void convertRec(String num, int currSegment, int currIndex, List<String> temp, List<List<String>> result) {
        if (currSegment == 4 && currIndex == num.length()) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (currIndex >= num.length() || currSegment > 4) {
            return;
        }
        for (int end = currIndex; end < num.length(); end++) {
            if (!isValid(num, currIndex, end)) {
                break;
            }
            temp.add(num.substring(currIndex, end + 1));
            convertRec(num, currSegment + 1, end + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isValid(String num, int start, int end) {
        int ip = 0;
        for (int i = start; i <= end; i++) {
            ip += ip * 10 + num.charAt(i) - '0';
        }
        return ip <= 255;
    }
}
