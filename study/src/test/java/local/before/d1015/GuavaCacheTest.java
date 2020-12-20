package local.before.d1015;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/15 下午4:04
 **/
public class GuavaCacheTest {

    LoadingCache<String, String> cache_no_refresh = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MILLISECONDS).build(
                    new CacheLoader<String, String>() {
                        Random random = new Random();

                        @Override
                        public String load(String key) throws Exception {
                            System.out.println("try loading");
                            Thread.sleep(1000);
                            return "test" + random.nextInt(10);
                        }
                    }
            );

    LoadingCache<String, String> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MILLISECONDS).build(
            new CacheLoader<String, String>() {
                Random random = new Random();

                @Override
                public String load(String key) throws Exception {
                    System.out.println("try loading");
                    Thread.sleep(1000);
                    return "test" + random.nextInt(10);
                }
            }
    );

    @Test
    public void test() throws InterruptedException, ExecutionException {
        System.out.println(cache.get("key"));
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(cache.get("key"));
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(5000);
    }

    @Test
    public void testGC() throws ExecutionException, InterruptedException {
        System.out.println(cache.get("key"));
        System.gc();
        Thread.sleep(100);
        System.out.println(cache.getIfPresent("key"));
    }

    @Test
    public void testTimeout() throws ExecutionException, InterruptedException {
        cache.get("key1");
        cache.get("key2");
        Thread.sleep(100);
        cache.get("key1");
        cache.get("key2");
    }

    @Test
    public void testNoFresh() throws Exception {
        cache_no_refresh.get("key");
        Thread.sleep(100);

        run(cache_no_refresh);
        run(cache_no_refresh);
        run(cache_no_refresh);
        run(cache_no_refresh);

        Thread.sleep(1500);
    }

    private void run(LoadingCache<String, String> usingCache) {
        new Thread(() -> {
            try {
                System.out.println(usingCache.get("key"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
