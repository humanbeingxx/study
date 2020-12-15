package local.algorithm.leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int forkFirst = Math.min((philosopher + 1) % 5, philosopher);
        int forkSecond = Math.max((philosopher + 1) % 5, philosopher);
        forks[forkFirst].lock();
        try {
            forks[forkSecond].lock();
            try {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
            } finally {
                forks[forkSecond].unlock();
            }
        } finally {
            forks[forkFirst].unlock();
        }
    }
}
