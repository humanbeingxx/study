package local.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pc
 * @date 2017/12/2
 */
public class LoggerStackOverFlow {

    private Logger logger = LoggerFactory.getLogger(LoggerStackOverFlow.class);

    public void log(String msg) {
        logger.info(msg);
    }
}
