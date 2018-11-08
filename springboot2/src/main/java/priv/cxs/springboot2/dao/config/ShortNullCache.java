package priv.cxs.springboot2.dao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/8 下午5:45
 **/
@Slf4j
public class ShortNullCache implements Cache {

    private final RedisTemplate template;

    private final static int EXPIRE_FOR_NORMAL = 10 * 60;

    private final static int EXPIRE_FOR_NULL = 10;

    public ShortNullCache(RedisTemplate template) {
        this.template = template;
    }

    @Override
    public String getName() {
        return "shortNullCache";
    }

    @Override
    public Object getNativeCache() {
        throw new UnsupportedOperationException("cannot get native cache");
    }

    @Override
    public ValueWrapper get(Object key) {
        key = makeKey(key);
        Object value = template.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof RedisNullValue) {
            return new SimpleValueWrapper(null);
        } else {
            return new SimpleValueWrapper(value);
        }
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        key = makeKey(key);
        return (T) template.opsForValue().get(key);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        key = makeKey(key);
        if (value == null) {
            template.opsForValue().set(key, RedisNullValue.getInstance(), EXPIRE_FOR_NULL, TimeUnit.SECONDS);
        } else {
            template.opsForValue().set(key, value, EXPIRE_FOR_NORMAL, TimeUnit.SECONDS);
        }
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        throw new UnsupportedOperationException("cannot putIfAbsent");
    }

    @Override
    public void evict(Object key) {
        key = makeKey(key);
        log.info("evicting {}", key);
        template.delete(key);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("cannot clear");
    }

    private String makeKey(Object key) {
        return "short_null_" + key;
    }
}
