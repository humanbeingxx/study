package local.other;

import lombok.SneakyThrows;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureTest {

    @Test
    public void test() throws InterruptedException {
        Map<String, String> values = Maps.newHashMap();
        values.put("key1", "value1");
        values.put("key2", "value2");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                Thread.sleep(1000);
                System.out.println(String.format("supplier with Thread %s", Thread.currentThread().getName()));
                return String.format("after sleep %s", String.join(",", values.values()));
            }
        });
        Thread.sleep(10000);
        completableFuture.whenComplete((s, throwable) -> {
            System.out.println(String.format("result received %s, current Thread %s", s, Thread.currentThread().getName()));
        });
        System.out.println(String.format("should before result, current Thread %s", Thread.currentThread().getName()));
        values.put("key3", "value3");
        Thread.sleep(1500);
    }
}
