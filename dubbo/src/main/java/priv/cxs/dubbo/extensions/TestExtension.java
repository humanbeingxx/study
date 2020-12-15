package priv.cxs.dubbo.extensions;

public class TestExtension implements MyExtension {
    @Override
    public String action() {
        return "test";
    }
}
