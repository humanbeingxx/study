package priv.cxs.springboot2.dao.config.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.google.common.collect.Lists;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/7 16:31
 */
@Configuration
public class RedisConfiguration {

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(fastjsonRedisSerializer());
        template.setDefaultSerializer(RedisSerializer.string());
        return template;
    }

    @Bean("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(30);
        config.setMaxTotal(50);
        config.setMinIdle(5);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisCacheConfiguration defaultCacheConfig() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .prefixKeysWith("cache_")
                .serializeValuesWith(fastjsonSerializationPair())
                .disableCachingNullValues();
    }

    @Bean(name = "defaultCache")
    @Primary
    public RedisCacheManager defaultCacheManager() {
        return RedisCacheManager
                .builder(redisConnectionFactory())
                .cacheDefaults(defaultCacheConfig())
                .build();
    }

    private FastJsonRedisSerializer<Object> fastjsonRedisSerializer() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        ParserConfig.getGlobalInstance().addAccept("org.springframework.cache.support.NullValue");
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteClassName);

        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        fastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);

        return fastJsonRedisSerializer;
    }

    private RedisSerializationContext.SerializationPair<Object> fastjsonSerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(fastjsonRedisSerializer());

    }

    @Bean
    public RedisCacheConfiguration shortLivedCacheConfig() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .prefixKeysWith("short_cache_")
                .serializeValuesWith(fastjsonSerializationPair())
                .entryTtl(Duration.ofSeconds(5));
    }

    @Bean(name = "shortLivedCache")
    public RedisCacheManager shortLivedCacheManager() {
        return RedisCacheManager
                .builder(redisConnectionFactory())
                .cacheDefaults(shortLivedCacheConfig())
                .build();
    }

    @Bean(name = "shortNullCache")
    public Cache shortNullCache() {
        return new ShortNullCache(redisTemplate());
    }

    @Bean
    public CacheManager myRedisCacheManager() {
        return new MyRedisCacheManager(Lists.newArrayList(shortNullCache()));
    }
}
