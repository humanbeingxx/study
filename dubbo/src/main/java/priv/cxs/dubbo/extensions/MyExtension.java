package priv.cxs.dubbo.extensions;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface MyExtension {

    String action();
}
