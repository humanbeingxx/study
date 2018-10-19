package local.logger;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/19 下午7:24
 **/
public class ListenFileStatusWithApacheMonitor {

    private FileAlterationMonitor monitor;
    public ListenFileStatusWithApacheMonitor(long interval) {
        monitor = new FileAlterationMonitor(interval);
    }

    public void monitor(String path, FileAlterationListener listener) {
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        monitor.addObserver(observer);
        observer.addListener(listener);
    }
    public void stop() throws Exception{
        monitor.stop();
    }
    public void start() throws Exception {
        monitor.start();
    }
    public static void main(String[] args) throws Exception {
        ListenFileStatusWithApacheMonitor m = new ListenFileStatusWithApacheMonitor(1000);
        m.monitor("/Users/xiaoshuang.cui/temp",new ListenFileStatusWithApacheListener());
        m.start();
    }
}
