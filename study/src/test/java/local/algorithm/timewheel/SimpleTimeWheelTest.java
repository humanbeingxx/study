package local.algorithm.timewheel;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/25 下午10:16
 **/
public class SimpleTimeWheelTest {

    private class SOUTTimeWheelTask extends AbstractTimeWheelTask {

        SOUTTimeWheelTask(int id, int timeout) {
            super(id, timeout);
        }

        @Override
        void invoke() {
            System.out.println(this.toString());
        }
    }

    @Test
    public void testAdd() {
        SimpleTimeWheel timeWheel = new SimpleTimeWheel(6, 1000);

        timeWheel.add(new SOUTTimeWheelTask(1, 1100));
        timeWheel.add(new SOUTTimeWheelTask(2, 1200));
        timeWheel.add(new SOUTTimeWheelTask(3, 2000));
        timeWheel.add(new SOUTTimeWheelTask(4, 2100));
        timeWheel.add(new SOUTTimeWheelTask(5, 3000));
        timeWheel.add(new SOUTTimeWheelTask(6, 3333));
        timeWheel.add(new SOUTTimeWheelTask(7, 5091));

        Assert.assertEquals(timeWheel.getSlots().get(0).show().size(), 0);
        Assert.assertEquals(timeWheel.getSlots().get(1).show().size(), 2);
        Assert.assertEquals(timeWheel.getSlots().get(2).show().size(), 2);
        Assert.assertEquals(timeWheel.getSlots().get(3).show().size(), 2);
        Assert.assertEquals(timeWheel.getSlots().get(4).show().size(), 0);
        Assert.assertEquals(timeWheel.getSlots().get(5).show().size(), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddLess() {
        SimpleTimeWheel timeWheel = new SimpleTimeWheel(6, 1000);

        timeWheel.add(new SOUTTimeWheelTask(1, 999));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddMore() {
        SimpleTimeWheel timeWheel = new SimpleTimeWheel(6, 1000);

        timeWheel.add(new SOUTTimeWheelTask(1, 7000));
    }


    @Test
    public void testSOUTStart() {
        SimpleTimeWheel timeWheel = new SimpleTimeWheel(6, 1000);

        timeWheel.add(new SOUTTimeWheelTask(1, 1100));
        timeWheel.add(new SOUTTimeWheelTask(2, 1200));
        timeWheel.add(new SOUTTimeWheelTask(3, 2000));
        timeWheel.add(new SOUTTimeWheelTask(4, 2100));
        timeWheel.add(new SOUTTimeWheelTask(5, 3000));
        timeWheel.add(new SOUTTimeWheelTask(6, 3333));
        timeWheel.add(new SOUTTimeWheelTask(7, 5091));

        timeWheel.start();
    }

    @Test
    public void testStart() throws InterruptedException {
        List<Integer> ran = Lists.newArrayList();

        class RecordTimeWheelTask extends AbstractTimeWheelTask {

            public RecordTimeWheelTask(int id, int timeout) {
                super(id, timeout);
            }

            @Override
            void invoke() {
                ran.add(this.getId());
            }
        }

        SimpleTimeWheel timeWheel = new SimpleTimeWheel(6, 1000);

        new Thread(timeWheel::start).start();

        timeWheel.add(new RecordTimeWheelTask(1, 2000));
        Thread.sleep(500);
        timeWheel.add(new RecordTimeWheelTask(2, 1000));
        Thread.sleep(1400);
        timeWheel.add(new RecordTimeWheelTask(3, 3300));
        Thread.sleep(300);
        timeWheel.add(new RecordTimeWheelTask(4, 1100));
        Thread.sleep(2000);
        timeWheel.add(new RecordTimeWheelTask(5, 2700));
        Thread.sleep(150);
        timeWheel.add(new RecordTimeWheelTask(6, 1000));

        Thread.sleep(6000);
        System.out.println(ran);
        Assert.assertEquals(ran, Lists.newArrayList(2, 1, 4, 3, 6, 5));

    }
}