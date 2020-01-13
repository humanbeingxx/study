package local.logger;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/19 下午6:56
 **/

import org.apache.log4j.helpers.FileWatchdog;

public class ListenFileStatusWithLog4j {
    public static void main(String[] args) {
        GloablConfig gloablConfig = new GloablConfig("/Users/xiaoshuang.cui/temp/temp");
        gloablConfig.setDelay(1000);
        gloablConfig.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class GloablConfig extends FileWatchdog {
        protected GloablConfig(String filename) {
            super(filename);
        }

        @Override
        protected void doOnChange() {
            System.out.println(filename);
        }


    }
}
