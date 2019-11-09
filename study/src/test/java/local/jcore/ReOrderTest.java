package local.jcore;

/**
 * @author cuixiaoshuang
 * @date 2019-07-02
 **/
public class ReOrderTest {

    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);
        stop = true;
    }
}
