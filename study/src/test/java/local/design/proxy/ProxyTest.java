package local.design.proxy;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午4:41
 **/
public class ProxyTest {

    interface ProxyCommand {

        String process(String input);
    }

    class CommandProxy {
        private ProxyCommand defaultCommand = input -> input;

        ProxyCommand getProxy() {
            return (ProxyCommand) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{ProxyCommand.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) {
                    System.out.println("before");
                    String result = defaultCommand.process((String) args[0]);
                    System.out.println("after");
                    return result;
                }
            });
        }
    }

    @Test
    public void test() {
        final boolean test = StringUtils.isBlank("test");
        System.out.println(test);
        final CommandProxy commandProxy = new CommandProxy();
        final ProxyCommand proxy = commandProxy.getProxy();
        proxy.process("test");
    }
}
