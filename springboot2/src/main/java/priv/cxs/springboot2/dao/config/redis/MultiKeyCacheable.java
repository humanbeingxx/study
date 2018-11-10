package priv.cxs.springboot2.dao.config.redis;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/9 下午5:53
 **/
public interface MultiKeyCacheable {

    String MULTI_KEY = "&&&";

    Splitter MULTI_KEY_SPLITTER = Splitter.on(MULTI_KEY);

    Joiner MULTI_KEY_JOINER = Joiner.on(MULTI_KEY);

    String generateKey();
}
