package priv.cxs.springboot2.dao.config.redis;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/8 下午6:16
 **/
public class MyRedisCacheManager implements CacheManager {

    private Map<String, Cache> cacheMap = Maps.newHashMap();

    public MyRedisCacheManager(List<Cache> caches) {
        Preconditions.checkNotNull(caches);
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(caches));

        for (Cache cache : caches) {
            cacheMap.put(cache.getName(), cache);
        }
    }

    @Override
    public Cache getCache(String name) {
        return cacheMap.get(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return cacheMap.keySet();
    }
}
