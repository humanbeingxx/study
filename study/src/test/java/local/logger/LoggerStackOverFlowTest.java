package local.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by pc on 2017/12/2.
 */
public class LoggerStackOverFlowTest {

    private static final Logger logger = LoggerFactory.getLogger("testFile");

    @Test
    public void testLog() throws Exception {
        new LoggerStackOverFlow().log("try to make overflow");
    }

    @Test
    public void testLogback() {
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is error");
    }
}