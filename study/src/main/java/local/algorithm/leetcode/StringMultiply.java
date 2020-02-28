package local.algorithm.leetcode;

public class StringMultiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - i - 1; j++) {
                sb.append(0);
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                int multi = digit1 * digit2 + carry;
                carry = multi / 10;
                sb.append(multi % 10);  
            }
            if (carry > 0) {
                sb.append(carry);
            }
            res = add(res, sb.reverse().toString());
        }
        return res;
    }

    String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 && index2 >= 0) {
            int sum = num1.charAt(index1) - '0' + num2.charAt(index2) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int sum = num1.charAt(index1) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index1--;
        }
        while (index2 >= 0) {
            int sum = num2.charAt(index2) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index2--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
