package priv.cxs.springboot2.dao.config.redis;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 支持自定义时间格式缓存，拼接在key中。e.g. key = @@60@@origin_key，表示60s超时，原始key是origin_key
 *
 * @author xiaoshuang.cui
 * @date 2018/11/8 下午5:45
 **/
@Slf4j
public class ShortNullCache implements Cache {

    public final static String ALLOW_NIL_PREFIX = "allowNil_";

    private final static Pattern KEY_PATTERN = Pattern.compile("(.*?)(@@.*@@)(.*)");

    private final RedisTemplate template;

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
        key = extractKey(key);
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
        key = extractKey(key);
        return (T) template.opsForValue().get(key);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        boolean allowNil = checkAllowNil(String.valueOf(key));
        ExpireKey expireKey = makeKey(key);
        if (value == null && !allowNil) {
            return;
        }
        if (value == null) {
            template.opsForValue().set(expireKey.key, RedisNullValue.getInstance(), EXPIRE_FOR_NULL, TimeUnit.SECONDS);
        } else {
            if (expireKey.seconds > 0) {
                template.opsForValue().set(expireKey.key, value, expireKey.seconds, TimeUnit.SECONDS);
            } else {
                template.opsForValue().set(expireKey.key, value);
            }
        }
    }

    private boolean checkAllowNil(String key) {
        return key.startsWith(ALLOW_NIL_PREFIX);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        throw new UnsupportedOperationException("cannot putIfAbsent");
    }

    @Override
    public void evict(Object key) {
        key = extractKey(key);
        List<String> keys = MultiKeyCacheable.MULTI_KEY_SPLITTER.splitToList(String.valueOf(key));
        log.info("evicting {}", keys);
        template.delete(keys);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("cannot clear");
    }

    private String extractKey(Object key) {
        Matcher matcher = KEY_PATTERN.matcher(String.valueOf(key).replaceFirst(ALLOW_NIL_PREFIX, ""));
        if (!matcher.find()) {
            return String.valueOf(key);
        }
        if (matcher.groupCount() == 1) {
            return matcher.group();
        }
        Preconditions.checkState(matcher.groupCount() == 3);
        return matcher.group(1) + matcher.group(3);
    }

    private ExpireKey makeKey(Object key) {
        Matcher matcher = KEY_PATTERN.matcher(String.valueOf(key).replaceFirst(ALLOW_NIL_PREFIX, ""));
        if (!matcher.find()) {
            return new ExpireKey(String.valueOf(key));
        }
        if (matcher.groupCount() == 1) {
            return new ExpireKey(matcher.group());
        }

        Preconditions.checkState(matcher.groupCount() == 3);

        String originKey = matcher.group(1) + matcher.group(3);
        String expireKeyStr = matcher.group(2);

        return new ExpireKey(originKey, parseDuration(expireKeyStr));
    }

    private int parseDuration(String str) {
        str = str.replaceAll("@@", "");
        if (StringUtils.isNumeric(str)) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    private class ExpireKey {
        private String key;
        private int seconds;

        private ExpireKey(String key) {
            this.key = key;
            this.seconds = 0;
        }

        private ExpireKey(String key, int seconds) {
            this.key = key;
            this.seconds = seconds;
        }
    }
}
