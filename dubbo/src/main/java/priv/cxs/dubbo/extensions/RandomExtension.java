package priv.cxs.dubbo.extensions;

import java.util.Random;

public class RandomExtension implements MyExtension {

    private Random random = new Random();

    @Override
    public String action() {
        return randomString(random.nextInt(10));
    }

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('a' + random.nextInt(26));
        }
        return sb.toString();
    }
}
