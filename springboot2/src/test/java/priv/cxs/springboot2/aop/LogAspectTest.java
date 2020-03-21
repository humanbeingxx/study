package priv.cxs.springboot2.aop;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;
import priv.cxs.springboot2.SpringBaseTest;

public class LogAspectTest extends SpringBaseTest {

    @Value("#{aspectUser1}")
    private AspectUser user1;

    @Value("#{aspectUser2}")
    private AspectUser user2;

    @Test
    public void testCallCount() {
        user1.call();
        user1.call();
        user2.call();
        user2.call();
    }

    @Test
    public void testOrder() {
        user1.logAll();
    }
}