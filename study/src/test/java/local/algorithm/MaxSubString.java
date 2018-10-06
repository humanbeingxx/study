package local.algorithm;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/6 下午3:18
 **/
public class MaxSubString {

    public static String max(String source) {
        String max = "";
        for (int i = 0; i < source.length(); i++) {
            for (int j = i + 1; j < source.length(); j++) {
                String target = source.substring(i, j);
                int targetLen = target.length();
                for (int k = i + 1; k + targetLen <= source.length(); k++) {
                    String tryStr = source.substring(k, k + targetLen);
                    if (tryStr.equals(target) && max.length() < targetLen) {
                        max = target;
                        break;
                    }
                }
            }
        }
        return max;
    }
}
