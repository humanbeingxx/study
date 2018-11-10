package priv.cxs.springboot2.dao.config.redis;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/8 下午10:22
 **/
public class RedisNullValue {

    private static RedisNullValue ourInstance = new RedisNullValue();

    public static RedisNullValue getInstance() {
        return ourInstance;
    }

    private RedisNullValue() {
    }
}
