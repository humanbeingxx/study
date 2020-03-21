package priv.cxs.springboot2.aop;

import org.springframework.stereotype.Component;

@Component
public class AspectUser1 implements AspectUser {

    @CallLogged
    @Override
    public void call() {
        System.out.println("user1 calling");
    }

    @Override
    @ResultLogged
    @ParamLogged
    @TimeLogged
    @CallLogged
    public String logAll() {
        return "user1 needs log";
    }
}
