package local.algorithm.leetcode;

public class Utf8Validation {

    public boolean validUtf8(int[] data) {
        int headIndex = 0, headData, length = -1;
        while (headIndex < data.length) {
            headData = data[headIndex];
            length = parseLength(headData);
            if (length == -1 || length + headIndex > data.length) {
                return false;
            }
            for (int i = 1; i < length; i++) {
                if (!checkPostfix(data[headIndex + i])) {
                    return false;
                }
            }
            headIndex += length;
        }
        return headIndex == data.length;
    }

    private boolean checkPostfix(int datum) {
        return (datum & 0b11000000) == 0b10000000;
    }

    private int parseLength(int headData) {
        if ((headData & 0b10000000) == 0) {
            return 1;
        } else if ((headData & 0b11100000) == 0b11000000) {
            return 2;
        } else if ((headData & 0b11110000) == 0b11100000) {
            return 3;
        } else if ((headData & 0b11111000) == 0b11110000) {
            return 4;
        } else {
            return -1;
        }
    }
}
