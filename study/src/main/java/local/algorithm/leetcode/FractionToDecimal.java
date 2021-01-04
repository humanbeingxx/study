package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == denominator) {
            return "1";
        }
        long num = numerator, deno = denominator;
        boolean isNeg = false;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            isNeg = true;
        }
        if (numerator < 0) {
            num = -num;
        }
        if (deno < 0) {
            deno = -deno;
        }

        long integerPart = num / deno;
        long left = num % deno;
        if (left == 0) {
            return (isNeg ? "-" : "") + integerPart;
        }
        String leftPart = calcLeft(left, deno);

        return (isNeg ? "-" : "") + integerPart + "." + leftPart;
    }

    private String calcLeft(long numerator, long denominator) {
        Map<Long, Integer> calculated = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int circleStart = -1;
        while (circleStart == -1 && numerator > 0) {
            int insertPos = stringBuilder.length();
            if (calculated.containsKey(numerator)) {
                circleStart = calculated.get(numerator);
                break;
            } else {
                calculated.put(numerator, insertPos);
            }
            numerator *= 10;
            insertPos++;
            while (numerator < denominator) {
                if (calculated.containsKey(numerator)) {
                    circleStart = calculated.get(numerator);
                    break;
                } else {
                    calculated.put(numerator, insertPos);
                }
                numerator *= 10;
                stringBuilder.append('0');
                insertPos++;
            }
            stringBuilder.append(numerator / denominator);
            numerator = numerator % denominator;
        }
        if (numerator != 0) {
            stringBuilder.insert(circleStart, '(');
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
