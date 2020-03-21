package priv.cxs.springboot2.aop;

import org.springframework.stereotype.Component;

@Component
public class AspectUser2 implements AspectUser {

    @CallLogged
    @Override
    public void call() {
        System.out.println("user2 calling");
    }
}
