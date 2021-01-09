package local.algorithm.leetcode;

public class MaxBinaryStringAfterChange {

    public String maximumBinaryString(String binary) {
        int index = 0;
        while (index < binary.length() && binary.charAt(index) == '1') {
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            stringBuilder.append('1');
        }
        int countOfZero = 0, countOfOne = 0;
        while (index < binary.length()) {
            if (binary.charAt(index) == '1') {
                countOfOne++;
            } else {
                countOfZero++;
            }
            index++;
        }

        if (countOfZero > 0) {
            for (int i = 0; i < countOfZero - 1; i++) {
                stringBuilder.append('1');
            }
            stringBuilder.append('0');
        }
        for (int i = 0; i < countOfOne; i++) {
            stringBuilder.append('1');
        }

        return stringBuilder.toString();
    }
}
