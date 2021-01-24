package local.interview_internal_reference.byhunter;

public class TraditionalRMB {

    public String translate(int amount) {
        if (amount == 0) {
            return "零元整";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int wan = amount / 10000;
        if (wan > 0) {
            stringBuilder.append(chinese(wan)).append("万");
        }
        amount -= 10000 * wan;
        int qian = amount / 1000;
        if (qian == 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("零");
            }
        } else {
            stringBuilder.append(chinese(qian)).append("千");
        }
        amount -= qian * 1000;
        int bai = amount / 100;
        if (bai == 0) {
            if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '零') {
                stringBuilder.append("零");
            }
        } else {
            stringBuilder.append(chinese(bai)).append("百");
        }
        amount -= bai * 100;
        int shi = amount / 10;
        if (shi == 0) {
            if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '零') {
                stringBuilder.append("零");
            }
        }else {
            stringBuilder.append(chinese(shi)).append("十");
        }
        int ge = amount - shi * 10;
        if (ge > 0) {
            stringBuilder.append(chinese(ge));
        }
        stringBuilder.append("元整");
        return stringBuilder.toString();
    }

    private String chinese(int num) {
        switch (num) {
            case 0:
                return "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }
}
