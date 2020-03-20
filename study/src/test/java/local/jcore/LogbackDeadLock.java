package local.jcore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDeadLock {

    static class A {
        private static final Logger logger = LoggerFactory.getLogger(A.class);

        public A() {
            try {
                logger.info("creating A");
            } catch (Exception e) {
                logger.error("error while creating A");
            }
        }
    }

    static class B {
        private static final Logger logger = LoggerFactory.getLogger(B.class);

        public static void main(String[] args) throws InterruptedException {
            new Thread(new Runnable() {
                public void run() {
                    logger.info(new B().toString());
                }
            }).start();
            new A();
        }

        @Override
        public String toString() {
            logger.info("[B.toString]");
            new A();
            return "[B.toString] finish";
        }
    }
}
