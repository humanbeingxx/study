package local.algorithm.nowcoder.yuanfudao;

import java.util.ArrayList;
import java.util.List;

public class ConvertToIP2 {

    public List<List<String>> convert(String source) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        convertRec(source, 0, 0, temp, result);
        return result;
    }

    private void convertRec(String source, int currentIpIndex, int currentSourceIndex, List<String> temp, List<List<String>> result) {
        if (currentIpIndex == 4 || currentSourceIndex == source.length()) {
            if (currentIpIndex == 4 && currentSourceIndex == source.length()) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = currentSourceIndex; i < source.length(); i++) {
            if (!isValidIp(source, currentSourceIndex, i)) {
                return;
            }
            temp.add(source.substring(currentSourceIndex, currentSourceIndex + 1));
            convertRec(source, currentIpIndex + 1, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isValidIp(String source, int start, int end) {
        int value = 0;
        for (int i = start; i <= end; i++) {
            value = value * 10 + source.charAt(i) - '0';
            if (value > 255) {
                return false;
            }
        }
        return true;
    }
}
