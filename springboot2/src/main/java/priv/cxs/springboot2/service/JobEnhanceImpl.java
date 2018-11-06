package priv.cxs.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:38
 **/
@Component
@Slf4j
public class JobEnhanceImpl implements JobEnhance {

    @Override
    public void enhanceTest() {
        log.info("this is for enhance test");
    }
}
