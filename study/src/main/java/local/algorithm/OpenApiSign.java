package local.algorithm;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;

public class OpenApiSign {

    public static final String MOCK_USER = "testUser";

    public static final String MOCK_PASSWD = "tesPWD";

    private static final int TIMEOUT = 1 * 1000;

    protected static Map<String, Long> usedUrl = Maps.newHashMap();

    protected static Set<String> tokens = Sets.newHashSet();

    public static String getToken(String userName, String password) {
        if (!checkUser(userName, password)) {
            return "";
        }

        String md5 = DigestUtils.md5Hex(userName + "::" + password);
        tokens.add(md5);
        return md5;
    }

    private static boolean checkUser(String userName, String password) {
        return MOCK_USER.equals(userName) && MOCK_PASSWD.equals(password);
    }

    public static String generateSign(String url) {
        String param = url.split("\\?")[1];
        return DigestUtils.md5Hex(param);
    }

    /**
     * 1. 用户名、密码的md5
     * 2. 时间戳
     * 3.
     */
    protected static boolean checkSign(String url) {
        String paramStr = url.split("\\?")[1];
        Map<String, String> parameters = Maps.newLinkedHashMap(
                Splitter.on("&").withKeyValueSeparator("=").split(paramStr));
        String sign = parameters.get("sign");
        if (StringUtils.isBlank(sign)) {
            return false;
        }
        parameters.remove("sign");
        String join = Joiner.on("&").withKeyValueSeparator("=").join(parameters);
        String md5 = DigestUtils.md5Hex(join);

        return md5.equals(sign);
    }

    public static void request(String url) {
        boolean checkSign = checkSign(url);
        if (!checkSign) {
            throw new IllegalArgumentException("invalid sign !!!");
        }

        long time = Long.parseLong(getParam(url, "time"));

        if (!usedUrl.containsKey(url)) {
            usedUrl.put(url, time);
            return;
        }

        if (System.currentTimeMillis() - usedUrl.get(url) > TIMEOUT) {
            usedUrl.put(url, time);
            return;
        }

        throw new IllegalStateException("request too often !!!");
    }

    private static String getParam(String url, String paramName) {
        String paramStr = url.split("\\?")[1];
        Map<String, String> parameters = Maps.newLinkedHashMap(
                Splitter.on("&").withKeyValueSeparator("=").split(paramStr));
        return parameters.get(paramName);
    }
}
