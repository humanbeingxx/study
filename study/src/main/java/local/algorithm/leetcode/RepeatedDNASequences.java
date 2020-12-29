package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        Set<Integer> existedCodes = new HashSet<>();
        Set<Integer> repeatedCodes = new HashSet<>();
        for (int i = 0; i <= chars.length - 10; i++) {
            Integer code = encode(chars, i);
            if (existedCodes.contains(code)) {
                repeatedCodes.add(code);
            } else {
                existedCodes.add(code);
            }
        }
        return repeatedCodes.stream().map(this::decode).collect(Collectors.toList());
    }

    private String decode(int code) {
        StringBuilder stringBuilder = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            switch (code & 3) {
                case 0:
                    stringBuilder.append('A');
                    break;
                case 1:
                    stringBuilder.append('C');
                    break;
                case 2:
                    stringBuilder.append('G');
                    break;
                case 3:
                    stringBuilder.append('T');
                    break;
                default:
                    break;
            }
            code >>= 2;
        }
        return stringBuilder.reverse().toString();
    }

    private Integer encode(char[] chars, int start) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            char c = chars[start + i];
            if (c == 'A') {
                result |= 0;
            } else if (c == 'C') {
                result |= 1;
            } else if (c == 'G') {
                result |= 2;
            } else {
                result |= 3;
            }
            result <<= 2;
        }
        result >>= 2;
        return result;
    }
}
