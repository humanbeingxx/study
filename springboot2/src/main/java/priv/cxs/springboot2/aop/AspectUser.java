package priv.cxs.springboot2.aop;

public interface AspectUser {

    void call();

    default String logAll() {
        return "";
    }
}
