package local.before.d1103.event;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 0:09
 */
public class EventTest {

    @AllArgsConstructor
    public static class TestData {
        private String value1;
        private String value2;
        private String value3;

        public String getValue1() {
            return value1;
        }

        public String getValue2() {
            return value2;
        }

        public String getValue3() {
            return value3;
        }
    }
    private static Notifier notifier = new Notifier();

    @BeforeClass
    public static void init() {
        notifier.addListener(event -> System.out.println(event.getMessage()));

        notifier.addListener(event -> System.out.println(event.getException().getMessage()));

        notifier.addListener(event -> {
            TestData data = (TestData) event.getData();
            System.out.println(JSON.toJSONString(data));
        });
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                notifier.publish(new Event() {
                    @Override
                    public String getMessage() {
                        return "first message";
                    }

                    @Override
                    public Exception getException() {
                        return new RuntimeException("first nothing happens really");
                    }

                    @Override
                    public Object getData() {
                        return new TestData("this is value1", "this is value2", "this is value3");
                    }
                });
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                notifier.publish(new Event() {
                    @Override
                    public String getMessage() {
                        return "second message";
                    }

                    @Override
                    public Exception getException() {
                        return new RuntimeException("second nothing happens really");
                    }

                    @Override
                    public Object getData() {
                        return new TestData("this is value2.1", "this is value2.2", "this is value2.3");
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                notifier.publish(new Event() {
                    @Override
                    public String getMessage() {
                        return "third message";
                    }

                    @Override
                    public Exception getException() {
                        return new RuntimeException("third nothing happens really");
                    }

                    @Override
                    public Object getData() {
                        return new TestData("this is value3.1", "this is value3.2", "this is value3.3");
                    }
                });
            }
        }).start();

        Thread.sleep(1000);
    }
}
