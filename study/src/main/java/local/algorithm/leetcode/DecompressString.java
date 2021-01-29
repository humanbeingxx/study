package local.algorithm.leetcode;

public class DecompressString {

    public String decompress(String compressed) {
        return decompressRec(compressed, 0, compressed.length() - 1).toString();
    }

    private StringBuilder decompressRec(String compressed, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        if (start >= compressed.length()) {
            return stringBuilder;
        }
        char startChar = compressed.charAt(start);
        if (startChar == '(') {
            int indexOfRight = end;
            for(; indexOfRight > start; indexOfRight--) {
                if (compressed.charAt(indexOfRight) == ')') {
                    break;
                }
            }
            if (indexOfRight == start) {
                throw new IllegalArgumentException();
            }
            StringBuilder inner = decompressRec(compressed, start + 1, indexOfRight - 1);
            if (indexOfRight < end) {
                char next = compressed.charAt(indexOfRight + 1);
                if (next >= '0' && next <='9') {
                    for (int i = 0; i < next - '0'; i++) {
                        stringBuilder.append(inner);
                    }
                    return stringBuilder.append(decompressRec(compressed, indexOfRight + 2, end));
                } else {
                    return stringBuilder.append(inner).append(decompressRec(compressed, indexOfRight + 1, end));
                }
            } else {
                return stringBuilder.append(inner).append(decompressRec(compressed, indexOfRight + 1, end));
            }
        } else if (startChar >= 'A' && startChar <= 'Z') {
            if (start + 1 < end) {
                char next = compressed.charAt(start + 1);
                if (next >= '0' && next <='9') {
                    for (int i = 0; i < next - '0'; i++) {
                        stringBuilder.append(startChar);
                    }
                    return stringBuilder.append(decompressRec(compressed, start + 2, end));
                } else {
                    stringBuilder.append(startChar);
                    return stringBuilder.append(decompressRec(compressed, start + 1, end));
                }
            } else {
                return stringBuilder.append(startChar).append(decompressRec(compressed, start + 1, end));
            }
        } else {
            return stringBuilder;
        }
    }
}
