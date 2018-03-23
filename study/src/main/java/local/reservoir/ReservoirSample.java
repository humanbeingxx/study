package local.reservoir;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author xiaoshuang.cui
 */
public class ReservoirSample {

    private int capacity;

    private List<Integer> content;

    /**
     * current index of scanned value in the stream
     */
    private int currentIndex = 1;

    private Random random = new Random();

    private boolean receiving = false;

    private Thread receiveThread;

    private boolean initialized = false;

    public ReservoirSample(int capacity, BlockingQueue<Integer> stream) {
        this.capacity = capacity;
        content = Lists.newArrayListWithCapacity(capacity);
        receiveThread = new Thread(() -> {
            while (receiving) {
                Integer element = null;
                try {
                    element = stream.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                putElement(element);
            }
        });
    }

    public synchronized void init() {
        Preconditions.checkState(!initialized, "cannot be initialize more than once");
        receiveThread.start();
    }

    public void receive() throws InterruptedException {
        Preconditions.checkState(initialized, "need initialize first");
        receiving = true;
    }

    private void putElement(Integer ele) {
        if (currentIndex <= capacity) {
            content.add(ele);
        } else {
            decideIfStay(ele);
        }
        currentIndex++;
    }

    /**
     * 从第j（k + 1 <= j <= n）个元素开始，每次先以概率p = k/j选择是否让第j个元素留下。
     * 若j被选中，则从A中随机选择一个元素并用该元素j替换它；否则直接淘汰该元素；
     */
    private void decideIfStay(Integer ele) {
        boolean ifKeep = decision(capacity, currentIndex);
        if (!ifKeep) {
            return;
        }
        int replaceIndex = Math.abs(random.nextInt(capacity));
        content.set(replaceIndex, ele);
    }

    /**
     * if hit with the probability of p/k
     */
    private boolean decision(int p, int k) {
        int roll = random.nextInt(k);
        return Math.abs(roll) < p;
    }

    public void stop() {
        receiving = false;
    }

    public ImmutableList<Integer> getResult() {
        return ImmutableList.copyOf(content);
    }
}
