package local.before.d1103.event;

import org.testng.collections.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/3 23:57
 */
public class Notifier {

    private List<Listener> listeners = Lists.newArrayList();

    private ExecutorService threadPool = new ThreadPoolExecutor(20, 50,
            1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(100), new ThreadPoolExecutor.DiscardPolicy());

    public synchronized void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void publish(Event event) {
        listeners.stream().forEach(listener -> threadPool.submit(new Runnable() {
            @Override
            public void run() {
                listener.receive(event);
            }
        }));
    }

    private static class Task implements Runnable {
        private Listener listener;
        private Event event;

        public Task(Listener listener, Event event) {
            this.listener = listener;
            this.event = event;
        }

        @Override
        public void run() {
            listener.receive(event);
        }
    }
}
