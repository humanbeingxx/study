package local.algorithm.timewheel;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/25 下午10:07
 **/
@Data
public class SimpleTimeWheel implements TimeWheel {

    private List<Slot> slots;

    private int slotDuration;

    private final AtomicInteger currentSlotPos = new AtomicInteger(0);

    private final AtomicInteger currentSlotElapse = new AtomicInteger(0);

    public SimpleTimeWheel(int slotNum, int slotDuration) {
        slots = Lists.newArrayListWithExpectedSize(slotNum);
        for (int i = 0; i < slotNum; i++) {
            slots.add(new Slot());
        }
        this.slotDuration = slotDuration;
    }

    @Override
    public void add(AbstractTimeWheelTask task) {
        if (task.getTimeout() < slotDuration || task.getTimeout() > slotDuration * slots.size()) {
            throw new IllegalArgumentException("cannot set timeout less than the least slot !");
        }

        synchronized (currentSlotPos) {
            synchronized (currentSlotElapse) {
                int slotPosCandidate = currentSlotPos.get()
                        + (currentSlotElapse.get() + task.getTimeout()) / slotDuration;
                if (slotPosCandidate >= slots.size()) {
                    slotPosCandidate = 0;
                }

                Slot slot = slots.get(slotPosCandidate);
                slot.add(task);
            }

        }

    }

    @Override
    public void start() {
        while (true) {
            advanceOneSlot();
        }
    }

    private void advanceOneSlot() {
        long startTime = System.currentTimeMillis();
        Slot slot = slots.get(currentSlotPos.get());

        int timeLeft = (int) (slotDuration - (System.currentTimeMillis() - startTime));
        AbstractTimeWheelTask task = slot.poll(timeLeft);

        while (task != null) {
            synchronized (currentSlotElapse) {
                currentSlotElapse.set((int) (System.currentTimeMillis() - startTime));
            }
            timeLeft = (int) (slotDuration - (System.currentTimeMillis() - startTime));
            System.out.println("running in " + currentSlotPos.get() + " for " + task.getId());
            task.invoke();
            task = slot.poll(timeLeft);
        }

        synchronized (currentSlotPos) {
            synchronized (currentSlotElapse) {
                currentSlotElapse.set(0);
            }
            if (currentSlotPos.get() + 1 == slots.size()) {
                currentSlotPos.set(0);
            } else {
                currentSlotPos.incrementAndGet();
            }
        }
    }
}
