package priv.cxs.dubbo;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(cluster = "failfast")
public class TestServiceImpl implements TestService {

    public TestServiceImpl() {
        System.out.println("init testService");
    }

    @Override
    public String nothing() {
        System.out.println("service invoked");
        return "???";
    }
}
