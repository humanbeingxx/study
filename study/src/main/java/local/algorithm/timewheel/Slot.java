package local.algorithm.timewheel;


import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/25 下午10:08
 **/
@Data
public class Slot {

    private int id;
    private BlockingQueue<AbstractTimeWheelTask> tasks = new LinkedBlockingDeque<>(10000);

    public void add(AbstractTimeWheelTask task) {
        tasks.add(task);
    }

    public AbstractTimeWheelTask poll() {
        return tasks.poll();
    }

    public AbstractTimeWheelTask poll(int timeout) {
        try {
            return tasks.poll(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AbstractTimeWheelTask> show() {
        return Lists.newArrayList(tasks.iterator());
    }
}
